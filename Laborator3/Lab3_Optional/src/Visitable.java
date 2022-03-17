import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    LocalTime getOpeningTime();

    LocalTime getClosingTime();
    void setOpeningTime(LocalTime ora);
    void setClosingTime(LocalTime ora);

    default void setDefaultOpeningTime() {
        setOpeningTime(LocalTime.of(9, 30));
    }

    default void setDefaultClosingTime() {
        setClosingTime(LocalTime.of(20, 00,00));
    }

    static Duration getVisitingDuration(LocalTime openTime, LocalTime closeTime) {
        return Duration.between(openTime, closeTime);
    }

}