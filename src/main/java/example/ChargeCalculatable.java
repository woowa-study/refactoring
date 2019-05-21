package example;

interface ChargeCalculatable<T extends ChargeCondition> {
    double chargeFee(T condition);

}
