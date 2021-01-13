package com.nishanth.formnnitiansbymnnitian.ebooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.nishanth.formnnitiansbymnnitian.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PdfViewer extends AppCompatActivity {

    private String url;
    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
        url=getIntent().getStringExtra("PdfUrl");
        pdfView=findViewById(R.id.pdfView);
        new PdfDownload().execute(url);



    }

    private class PdfDownload extends AsyncTask<String, Void, InputStream>{

        @Override
        protected InputStream doInBackground(String... strings) {
                 InputStream inputstream=null;
            try {
                URL url= new URL(strings[0]);
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                if(connection.getResponseCode()==200)
                {
                    inputstream=new BufferedInputStream(connection.getInputStream());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return inputstream;
        }



        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
        }
    }


}