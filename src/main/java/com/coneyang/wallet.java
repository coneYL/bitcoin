package com.coneyang;


import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;

import java.security.*;

public class wallet {
    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchProviderException, NoSuchAlgorithmException {
        Security.addProvider(new BouncyCastleProvider());
        // 创建椭圆曲线算法的密钥对生成器，算法为 ECDSA
        KeyPairGenerator g;
        g = KeyPairGenerator.getInstance("ECDSA", BouncyCastleProvider.PROVIDER_NAME);
        // 椭圆曲线（EC）域参数设定
        // bitcoin 为什么会选择 secp256k1，详见：https://bitcointalk.org/index.php?topic=151120.0
        ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec("secp256k1");
        g.initialize(ecSpec, new SecureRandom());
        KeyPair pair = g.generateKeyPair();
        PrivateKey privateKey =pair.getPrivate();
        System.out.println(privateKey.toString());
        System.out.println(pair.getPublic().toString());
    }
}
