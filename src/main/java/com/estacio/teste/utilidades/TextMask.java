package com.estacio.teste.utilidades;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class TextMask {

    public static final String FORMAT_CPF = "###.###.###-##";
    public static final String FORMAT_CELULAR = "(##) #####-####";
    public static final String FORMAT_CNPJ = "##.###.###/####-##";
    public static final String FORMAT_CEP = "#####-###";
    public static final String FORMAT_DATE = "##/##/####";
    public static final String FORMAT_HOUR = "##:##";

    /**
     * Método que deve ser chamado para realizar a foramatação
     *
     * @param ediTxt
     * @param mask
     * @return
     */

    public static TextWatcher mask (final EditText editText, final String mask) {
        return new TextWatcher() {
            boolean isUpdating;
            String old = "";

            @Override
            public void afterTextChanged(Editable s) { }

            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) { }

            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
                final String str = TextMask.unmask(s.toString());
                String mascara = "";
                if (isUpdating){
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (final char m : mask.toCharArray()) {
                    if (m != '#' && str.length() > old.length()) {
                        mascara += m;
                        continue;
                    }
                    try {
                        mascara += str.charAt(i);
                    } catch (final Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                editText.setText(mascara);
                editText.setSelection(mascara.length());
            }

        };
    }
    public static String unmask (final String s) {
        return s.replaceAll("[.]","").replaceAll("[-]", "").replaceAll("[/]", "").replaceAll("[(]", "").replaceAll("[)]", "");
    }
}
