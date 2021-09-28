package com.example.screenorientation.EncryptAndDecrypt

import android.util.Base64
import java.io.UnsupportedEncodingException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.spec.InvalidParameterSpecException
import javax.crypto.*
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

object DataStore {


    @Throws(
        NoSuchAlgorithmException::class,
        NoSuchPaddingException::class,
        InvalidKeyException::class,
        InvalidParameterSpecException::class,
        IllegalBlockSizeException::class,
        BadPaddingException::class,
        UnsupportedEncodingException::class
    )
    fun encrypt(message: String, secret: SecretKey?): String? {
        var cipher: Cipher? = null
        cipher = Cipher.getInstance("AES/CBc/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, secret)
        val cipherText = cipher.doFinal(message.toByteArray(charset("UTF-8")))
        return Base64.encodeToString(cipherText, Base64.NO_WRAP)
    }

    fun decrypt(cipherText: String?, key: SecretKey): String {
        val decode:String
        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, key)
        val iv:ByteArray = Base64.decode(cipherText, Base64.NO_WRAP)
        decode = cipher.doFinal(iv).toString()
        return decode
    }
    fun secretKey(key: String): SecretKeySpec {
        return SecretKeySpec(key.toByteArray(), "AES")
    }

}



