class Main {
    public static void main(String[] args) {
        (new Main()).init();
    }

    void print(Object o) { System.out.println(o); }

    void init() {
        String file = "i like bananas and apples";
        int[] shiftPattern = {3, 1, 4, 1, 5};

        //  ENCODING 
        String encodedMsg1 = polyalphabeticShift(file, shiftPattern);
        print("Encoded Message 1 (Polyalphabetic Shift): " + encodedMsg1);

        String encodedMsg2 = creativeSplittingRecombination(encodedMsg1);
        print("Encoded Message 2 (Splitting + Recombination): " + encodedMsg2);

        String encodedMsg3 = bitLevelManipulation(encodedMsg2);
        print("Encoded Message 3 (Bit-Level Manipulation): " + encodedMsg3);


        //  DECODING 
        String decodedMsg3 = reverseBitLevelManipulation(encodedMsg3);
        print("Decoded Message 3 (Reversed Bit Manipulation): " + decodedMsg3);

        String decodedMsg1 = reverseSplittingRecombination(decodedMsg3);
        print("Decoded Message 1 (Reversed Splitting + Recombination): " + decodedMsg1);

        String decodedMsg2 = reversePolyalphabeticShift(decodedMsg1, shiftPattern);
        print("Decoded Message 2 (FINAL): " + decodedMsg2);
    }

    // Layer 1: Polyalphabetic Shift
    String polyalphabeticShift(String txt, int[] shiftPattern) {
        char[] arr = txt.toCharArray();
        int len = shiftPattern.length;

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (Character.isLetter(c)) {
                int shift = shiftPattern[i % len];
                if (Character.isLowerCase(c)) {
                    arr[i] = (char) ((c - 'a' + shift) % 26 + 'a');
                } else {
                    arr[i] = (char) ((c - 'A' + shift) % 26 + 'A');
                }
            }
        }
        return new String(arr);
    }

    // Layer 2: Creative Splitting + Recombination
    String creativeSplittingRecombination(String txt) {
        char[] arr = txt.toCharArray();
        String nonPrime = "", prime = "";

        for (int i = 0; i < arr.length; i++) {
            if (isPrime(i + 1)) prime += arr[i];
            else nonPrime += arr[i];
        }
        return nonPrime + prime;
    }

    boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    // Layer 3: Bit-Level Manipulation
    String bitLevelManipulation(String txt) {
        char[] array = txt.toCharArray();

        for (int i = 0; i < array.length; i++) {
            char c = array[i];

            String bin = String.format("%8s", Integer.toBinaryString(c))
                            .replace(' ', '0');

            String rot = bin.substring(2) + bin.substring(0, 2);

            String flipped = "";
            for (char b : rot.toCharArray())
                flipped += (b == '0' ? '1' : '0');

            array[i] = (char) Integer.parseInt(flipped, 2);
        }
        return new String(array);
    }

    // REVERSE: Bit-Level Manipulation
    String reverseBitLevelManipulation(String txt) {
        char[] arr = txt.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            String bin = String.format("%8s", Integer.toBinaryString(c & 0xFF))
                            .replace(' ', '0');  

            String unflip = "";
            for (char b : bin.toCharArray())
                unflip += (b == '0' ? '1' : '0');

            String restored = unflip.substring(6) + unflip.substring(0, 6);

            arr[i] = (char) Integer.parseInt(restored, 2);
        }

        return new String(arr);
    }

    // REVERSE: Splitting + Recombination 
    String reverseSplittingRecombination(String txt) {
        int n = txt.length();

        int nonPrimeCount = 0;
        for (int i = 0; i < n; i++)
            if (!isPrime(i + 1))
                nonPrimeCount++;

        String nonPrimeBlock = txt.substring(0, nonPrimeCount);
        String primeBlock = txt.substring(nonPrimeCount);

        char[] result = new char[n];
        int idxNon = 0, idxPrime = 0;

        for (int i = 0; i < n; i++) {
            if (!isPrime(i + 1))
                result[i] = nonPrimeBlock.charAt(idxNon++);
            else
                result[i] = primeBlock.charAt(idxPrime++);
        }

        return new String(result);
    }

    // REVERSE: Polyalphabetic Shift
    String reversePolyalphabeticShift(String txt, int[] shiftPattern) {
        char[] arr = txt.toCharArray();
        int len = shiftPattern.length;

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (Character.isLetter(c)) {
                int shift = shiftPattern[i % len];
                if (Character.isLowerCase(c)) {
                    arr[i] = (char) ((c - 'a' - shift + 26) % 26 + 'a');
                } else {
                    arr[i] = (char) ((c - 'A' - shift + 26) % 26 + 'A');
                }
            }
        }

        return new String(arr);
    }
}
