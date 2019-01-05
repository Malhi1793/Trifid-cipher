# Trifid-cipher
This is a java application that encrypts any text file using a modified version of the Trifid-cipher technique, and then hides the decryption password into an image.

## What is the trifid-cipher?
The trifid cipher is a classical cipher invented by Félix Delastelle and described in 1902. Extending the principles of Delastelle's earlier bifid cipher, it combines the techniques of fractionation and transposition to achieve a certain amount of confusion and diffusion: each letter of the ciphertext depends on three letters of the plaintext and up to three letters of the key.

For a step by step discussion on how to use the trifid cipher refer to the link: [Trifid Cipher](https://en.wikipedia.org/wiki/Trifid_cipher)

## The modifications:
- In my program, instead of using the classic 3x3x3 matrix, I've used a 5x5x5 matrix to accomodate 125 characters of the ASCII alphabet.
- Also, instead of directly entering numbers in a sequential pattern into the matrix, we first hash it with a string of 32 digits, which gives a random ordering of the letters and adds another layer of protection to the algorithm.
- Once everything is in place the algorthm works as described in the above link, but the decryption key is hidden inside an image using steganography.

# Usage of the application
1. Inside the `/src/finalFunc.java` change the `key` variable to any random string of your choice.
1. In the same file chanage the paths `D:\Malhi\Deign\Frosh18` to paths of your choice.
1. Edit the same paths in `/src/files.java`, `/src/finalFuncDec.java`
1. Edit the `enckey` variable in `/src/encryptText.java` to any 32 digit array of your choice, and copy this array to the `enckey` variable in `/src/decryptText.java`
1. Save the changes and run the `/src/appPane1.java` using Eclipse or any other java compiler.
