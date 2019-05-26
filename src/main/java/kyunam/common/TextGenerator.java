package kyunam.common;

import kyunam.rental.dto.RentalInfo;

import java.util.List;
import java.util.stream.Collectors;

public class TextGenerator {
    public static String getRentalInfoText(RentalInfo rentalInfo) {
        StringBuilder builder = new StringBuilder();
        builder.append(rentalInfo.getTitle());
        builder.append("\t");
        builder.append(rentalInfo.getRentalFee());
        builder.append(System.lineSeparator());
        return builder.toString();
    }

    public static String getRentalInfoListText(List<RentalInfo> rentalInfos) {
        return rentalInfos.stream().map(rentalInfo -> getRentalInfoText(rentalInfo)).collect(Collectors.joining());
    }
}
