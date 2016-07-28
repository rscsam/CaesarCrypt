package com.caesar_crypt.sylan.caesarcrypt;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("CaesarCrypt by Sylan");
        final Spinner keySpinner = (Spinner) findViewById(R.id.spnr_keys);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.keys_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        keySpinner.setAdapter(adapter);
        final Button bEncrypt = (Button) findViewById(R.id.bttn_encrypt);
        final Button bDecrypt = (Button) findViewById(R.id.bttn_decrypt);
        EditText etText = (EditText) findViewById(R.id.et_text);
        final TextView tvResult = (TextView) findViewById(R.id.tv_result);
        bEncrypt.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        String in = ((EditText) findViewById(R.id.et_text)).getText().toString();
                        String out = Caesar.encrypt(in, keySpinner.getSelectedItemPosition() - 1);
                        tvResult.setText(out);
                        View view = getCurrentFocus();
                        if (view != null) {
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                    }
                });
        bDecrypt.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        String in = ((EditText) findViewById(R.id.et_text)).getText().toString();
                        String out = Caesar.decrypt(in, keySpinner.getSelectedItemPosition() - 1);
                        tvResult.setText(out);
                        View view = getCurrentFocus();
                        if (view != null) {
                            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                    }
                });
    }
}
