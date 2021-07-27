package com.hightech.unittesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.security.SecureRandom
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val byteArray = ByteArray(16)
        val secureRandom = SecureRandom()
        secureRandom.nextBytes(byteArray)

        val keyGenerator = KeyGenerator.getInstance("AES")
        keyGenerator.init(256)
        val secretKey: SecretKey = keyGenerator.generateKey()
        Log.d("MainActivity", "Random Key : ${secretKey.encoded}")

        val encryptedText = AesEncryption.encrypt(
            data = "Fiqri Hafzain Islami",
            secretKey = secretKey,
            byteArray = secureRandom.generateSeed(16)
        )

        Log.d("MainActivity", "Encrypted : $encryptedText")

        val decryptedText = AesEncryption.decrypt(
            encryptedText = encryptedText,
            secretKey = secretKey,
            byteArray = secureRandom.generateSeed(16)
        )

        Log.d("MainActivity", "Decrypted : $decryptedText")
    }
}