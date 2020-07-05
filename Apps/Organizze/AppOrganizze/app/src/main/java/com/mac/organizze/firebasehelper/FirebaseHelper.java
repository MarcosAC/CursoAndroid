package com.mac.organizze.firebasehelper;

import com.google.firebase.auth.FirebaseAuth;

public class FirebaseHelper {

    private static FirebaseAuth autenticacao;

    public static FirebaseAuth getAutenticacao() {

        if (autenticacao == null)
            autenticacao = FirebaseAuth.getInstance();

        return autenticacao;
    }
}
