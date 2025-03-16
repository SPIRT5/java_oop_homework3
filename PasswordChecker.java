public class PasswordChecker {
    private int minLenght = -1;
    private int maxRepeats = -1;

    public void setMinLength(int minLenght) {
        if (minLenght < 0) {
            throw new IllegalArgumentException("Длина пароля не может быть отрицательной");
        }
        this.minLenght = minLenght;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats < 0) {
            throw new IllegalArgumentException("Количество повторений не может быть отрицательным");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {
        if (minLenght == -1 || maxRepeats == -1) {
            throw new IllegalStateException("Чеккер не настроен");
        }
        if (password.length() < minLenght) {
            return false;
        }
        int counter = 0;
        char previousLetter = password.charAt(0);
        for (char letter : password.toCharArray()) {
            if (letter == previousLetter) {
                counter++;
            } else {
                counter = 1;
            }
            if (counter > maxRepeats) {
                return false;
            }
            previousLetter = letter;

        }
        return true;
    }
}
