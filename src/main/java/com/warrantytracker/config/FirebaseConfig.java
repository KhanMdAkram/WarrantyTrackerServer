package com.warrantytracker.config;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {
	
	@Value("${firebase.database.url}")
	String firebaseDatabaseUrl;
	
	@Value("${firebase.config.path}")
	String firebaseConfigPath;
	
	@PostConstruct
	public void initializeFirebase() {
		FirebaseOptions options;
		try {
			FileInputStream serviceAccount = new FileInputStream(firebaseConfigPath);
			options = new FirebaseOptions.Builder()
				    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				    .setDatabaseUrl(firebaseDatabaseUrl)
				    .build();
			FirebaseApp.initializeApp(options);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
//	@Bean
//    public DatabaseReference firebaseDatabse() {
//        DatabaseReference firebase = FirebaseDatabase.getInstance().getReference();
//        return firebase;
//    }

}
