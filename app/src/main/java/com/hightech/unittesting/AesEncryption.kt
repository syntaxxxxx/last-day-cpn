package com.hightech.unittesting

import android.annotation.SuppressLint
import android.util.Base64
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object AesEncryption {

    @SuppressLint("GetInstance")
    fun encrypt(data: String, secretKey: SecretKey, byteArray: ByteArray): String {
        val cipher = Cipher.getInstance("AES")
        val secretKeySpec = SecretKeySpec(secretKey.encoded, "AES")
        val parameterSpec = IvParameterSpec(byteArray)
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, parameterSpec)
        val cipherText: ByteArray = cipher.doFinal(data.toByteArray())
        return Base64.encodeToString(cipherText, Base64.DEFAULT)
    }

    @SuppressLint("GetInstance")
    fun decrypt(encryptedText: String, secretKey: SecretKey, byteArray: ByteArray): String {
        val cipherText = Base64.decode(encryptedText, Base64.DEFAULT)
        val cipher = Cipher.getInstance("AES")
        val secretKeySpec = SecretKeySpec(secretKey.encoded, "AES")
        val parameterSpec = IvParameterSpec(byteArray)
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, parameterSpec)
        return String(cipher.doFinal(cipherText))
    }

}