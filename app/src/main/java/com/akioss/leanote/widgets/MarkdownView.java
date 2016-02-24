package com.akioss.leanote.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

import com.petebevin.markdown.MarkdownProcessor;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/2/23.
 * Package: com.akioss.leanote.widgets
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class MarkdownView extends WebView {

    private static final String TAG = "MarkdownView";

    public MarkdownView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarkdownView(Context context) {
        super(context);
    }

    /**
     * Loads the given Markdown text to the view as rich formatted HTML. The
     * HTML output will be styled based on the given CSS file.
     *
     * @param txt
     *            - input in markdown format
     * @param cssFileUrl
     *            - a URL to css File. If the file located in the project assets
     *            folder then the URL should start with "file:///android_asset/"
     */
    public void loadMarkdown(String txt, String cssFileUrl) {
        loadMarkdownToView(txt, cssFileUrl);
    }

    /**
     * Loads the given Markdown text to the view as rich formatted HTML.
     *
     * @param txt
     *            - input in Markdown format
     */
    public void loadMarkdown(String txt) {
        loadMarkdown(txt, null);
    }

    private void loadMarkdownToView(String txt, String cssFileUrl) {
        MarkdownProcessor m = new MarkdownProcessor();
        String html = m.markdown(txt);
        if (cssFileUrl != null) {
            html = 	"<link rel='stylesheet' type='text/css' href='"+ cssFileUrl +"' />" + html;
        }
        loadDataWithBaseURL("fake://", html, "text/html", "UTF-8", null);
    }
}
