package htsi.test.demowebview;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText urlText;
	private Button goButton;

	private WebView webView;

	  @Override
	  public void onCreate(Bundle savedInstanceState) {

	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_main);

	    urlText = (EditText) findViewById(R.id.urlfield);
	    goButton = (Button) findViewById(R.id.go_button);
	    webView = (WebView) findViewById(R.id.web_view);
	    goButton.setOnClickListener(new OnClickListener() {
	      public void onClick(View view) {
	        openBrowser();
	      }
	    });
	    
	    urlText.setOnKeyListener(new OnKeyListener() {
	      public boolean onKey(View view, int keyCode, KeyEvent event) {
	        if (keyCode == KeyEvent.KEYCODE_ENTER) {
	          openBrowser();
	          return true;
	        }
	        return false;
	      }
	    });

	  }
	  
	  private void openBrowser() {
		    webView.loadUrl("http://" + urlText.getText().toString());
		    webView.requestFocus();
	  }

}
