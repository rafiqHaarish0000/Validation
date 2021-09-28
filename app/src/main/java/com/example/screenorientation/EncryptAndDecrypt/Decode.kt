package com.example.screenorientation.EncryptAndDecrypt

import java.lang.Exception
import java.security.InvalidAlgorithmParameterException
import java.security.InvalidKeyException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import javax.crypto.*
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import kotlin.Throws

internal abstract class Decode {
    companion object {
        @Throws(
            NoSuchPaddingException::class,
            NoSuchAlgorithmException::class,
            InvalidAlgorithmParameterException::class,
            InvalidKeyException::class
        )
        fun encrypt(plaintText: String?): Any {
            val secretKey: SecretKey
            val generator: KeyGenerator = KeyGenerator.getInstance("AES")
            generator.init(256)
            secretKey = generator.generateKey()
            var IV:ByteArray = ByteArray(16)
            val random: SecureRandom = SecureRandom()
            random.nextBytes(IV)
            val cipher = Cipher.getInstance("AES")
            val keySpec = SecretKeySpec(secretKey.encoded, "AES")
            val ivSpec = IvParameterSpec(IV)
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec)
            var cipherText = ByteArray(0)
            try {
                cipherText = cipher.doFinal(plaintText!!.toByteArray())
            } catch (e: BadPaddingException) {
                e.printStackTrace()
            } catch (e: IllegalBlockSizeException) {
                e.printStackTrace()
            }
            return cipherText
        }

        @Throws(
            NoSuchPaddingException::class,
            NoSuchAlgorithmException::class,
            InvalidAlgorithmParameterException::class,
            InvalidKeyException::class,
            BadPaddingException::class,
            IllegalBlockSizeException::class
        )
        fun decrypt(cipherKey: String?): Any? {
            val IV:ByteArray
            val generator: KeyGenerator
            val secretKey: SecretKey
            generator = KeyGenerator.getInstance("AES")
            generator.init(256)
            secretKey = generator.generateKey()
            IV = ByteArray(16)
            val random: SecureRandom
            random = SecureRandom()
            random.nextBytes(IV)
            try {
                val cipher = Cipher.getInstance("AES")
                val keySpec = SecretKeySpec(secretKey.encoded, "AES")
                val ivSpec = IvParameterSpec(IV)
                cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec)
                val decryptText = cipher.doFinal(cipherKey!!.toByteArray())
                return String(decryptText)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }
    }
}