class Main {
    public static void main(String[] args) {
        (new Main()).init();
    }

    void print(Object o) { System.out.println(o); }
    void printt(Object o) { System.out.print(o); }

    void init() {
        // Example message
        String file = "hello world";  // Example message to encrypt.

        // Step 1: Apply Polyalphabetic Shift
        int[] shiftPattern = {3, 1, 4, 1, 5};  // Example shift pattern
        String encodedMsg1 = polyalphabeticShift(file, shiftPattern);
        print("Encoded Message 1 (Polyalphabetic Shift): " + encodedMsg1);

        // Step 2: Apply Creative Splitting + Recombination
        String encodedMsg2 = creativeSplittingRecombination(encodedMsg1);
        print("Encoded Message 2 (Splitting + Recombination): " + encodedMsg2);

        // Step 3: Apply Bit-Level Binary Manipulation
        String encodedMsg3 = bitLevelManipulation(encodedMsg2);
        print("Encoded Message 3 (Bit-Level Manipulation): " + encodedMsg3);

        // Decoding Process (reversing the transformations)
        String decodedMsg1 = reverseSplittingRecombination(encodedMsg3);
        print("Decoded Message 1 (Reversed Splitting + Recombination): " + decodedMsg1);

        String decodedMsg2 = reversePolyalphabeticShift(decodedMsg1, shiftPattern);
        print("Decoded Message 2 (Reversed Polyalphabetic Shift): " + decodedMsg2);
    }

    // **Layer 1: Polyalphabetic Shift**
    String polyalphabeticShift(String txt, int[] shiftPattern) {
        char[] charArray = txt.toCharArray();
        int shiftLen = shiftPattern.length;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (Character.isLetter(c)) {
                int shift = shiftPattern[i % shiftLen];
                if (Character.isLowerCase(c)) {
                    charArray[i] = (char) ((c - 'a' + shift) % 26 + 'a');
                } else if (Character.isUpperCase(c)) {
                    charArray[i] = (char) ((c - 'A' + shift) % 26 + 'A');
                }
            }
        }
        return new String(charArray);
    }

    // **Layer 2: Creative Splitting + Recombination**
    String creativeSplittingRecombination(String txt) {
        char[] charArray = txt.toCharArray();
        String nonPrime = "";
        String prime = "";

        // Split into prime and non-prime index characters
        for (int i = 0; i < charArray.length; i++) {
            if (isPrime(i + 1)) {
                prime += charArray[i];
            } else {
                nonPrime += charArray[i];
            }
        }

        // Recombine non-prime block first, then prime block
        return nonPrime + prime;
    }

    // Helper method to check if an index is prime (1-based indexing)
    boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // **Layer 3: Bit-Level Binary Manipulation (Rotate + Flip Bits)**
    String bitLevelManipulation(String txt) {
        char[] charArray = txt.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            String binary = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');

            // Rotate left by 2 bits
            String rotated = binary.substring(2) + binary.substring(0, 2);

            // Flip bits (binary complement)
            String flipped = "";
            for (int j = 0; j < rotated.length(); j++) {
                flipped += rotated.charAt(j) == '0' ? '1' : '0';
            }

            // Convert flipped binary back to character
            charArray[i] = (char) Integer.parseInt(flipped, 2);
        }
        return new String(charArray);
    }

    // **Reversing the Split and Recombination Step**
    String reverseSplittingRecombination(String txt) {
        // Reverse the recombination (swap the prime and non-prime blocks)
        char[] charArray = txt.toCharArray();
        String nonPrime = "";
        String prime = "";

        for (int i = 0; i < charArray.length; i++) {
            if (isPrime(i + 1)) {
                prime += charArray[i];
            } else {
                nonPrime += charArray[i];
            }
        }

        return prime + nonPrime;  // Reversed order of recombination
    }

    // Reverse the Polyalphabetic Shift by applying the inverse of each shift
    String reversePolyalphabeticShift(String txt, int[] shiftPattern) {
        char[] charArray = txt.toCharArray();
        int shiftLen = shiftPattern.length;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (Character.isLetter(c)) {
                int shift = shiftPattern[i % shiftLen];
                if (Character.isLowerCase(c)) {
                    charArray[i] = (char) ((c - 'a' - shift + 26) % 26 + 'a');
                } else if (Character.isUpperCase(c)) {
                    charArray[i] = (char) ((c - 'A' - shift + 26) % 26 + 'A');
                }
            }
        }
        return new String(charArray);
    }
}
