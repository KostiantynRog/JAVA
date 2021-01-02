package homework12;

public class FamilyOverflowException extends RuntimeException{
    public FamilyOverflowException(int count){
        super(String.format("This family bigger than %d, ", count));
    }
}
