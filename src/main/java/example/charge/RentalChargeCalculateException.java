package example.charge;

public class RentalChargeCalculateException extends RuntimeException {
    public RentalChargeCalculateException() {
    }

    public RentalChargeCalculateException(String message) {
        super(message);
    }

    public static class NoRuleAppliedException extends RentalChargeCalculateException{
        public NoRuleAppliedException() {
            super();
        }
    }
}
