//package model;
//
//import lombok.SneakyThrows;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.MethodSource;
//import se.ifmo.web.hard_lab2.dto.DirtyPoint;
//import se.ifmo.web.hard_lab2.model.AreaChecker;
//import se.ifmo.web.hard_lab2.model.Validator;
//
//import java.util.stream.Stream;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class AreaCheckerTest {
//    static Stream<Validator> checkTopLeft_True() {
//        return Stream.of(
//                new Validator(new DirtyPoint("-1", "2", "3")),
//                new Validator(new DirtyPoint("0", "0", "5")),
//                new Validator(new DirtyPoint("-2", "0", "2")),
//                new Validator(new DirtyPoint("-3", "2", "5")),
//                new Validator(new DirtyPoint("0", "5", "5"))
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    @SneakyThrows
//    public void checkTopLeft_True(Validator validator) {
//        validator.validate();
//        assertTrue(AreaChecker.isInArea(validator.getX(), validator.getY(), validator.getR()));
//    }
//
//    static Stream<Validator> checkTopLeft_False() {
//        return Stream.of(
//                new Validator(new DirtyPoint("-3", "2", "3")),
//                new Validator(new DirtyPoint("-3", "0", "2.99")),
//                new Validator(new DirtyPoint("-3", "5", "4"))
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    @SneakyThrows
//    public void checkTopLeft_False(Validator validator) {
//        validator.validate();
//        assertFalse(AreaChecker.isInArea(validator.getX(), validator.getY(), validator.getR()));
//    }
//
//    static Stream<Validator> checkTopRight_True() {
//        return Stream.of(
//                new Validator(new DirtyPoint("1", "0", "2")),
//                new Validator(new DirtyPoint("0", "0.001", "4")),
//                new Validator(new DirtyPoint("0", "0", "3")),
//                new Validator(new DirtyPoint("4", "4", "4")),
//                new Validator(new DirtyPoint("1", "3", "5"))
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    @SneakyThrows
//    public void checkTopRight_True(Validator validator) {
//        validator.validate();
//        assertTrue(AreaChecker.isInArea(validator.getX(), validator.getY(), validator.getR()));
//    }
//
//    static Stream<Validator> checkTopRight_False() {
//        return Stream.of(
//                new Validator(new DirtyPoint("2", "3.0001", "3")),
//                new Validator(new DirtyPoint("4", "0", "3.89")),
//                new Validator(new DirtyPoint("4", "4", "2"))
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    @SneakyThrows
//    public void checkTopRight_False(Validator validator) {
//        validator.validate();
//        assertFalse(AreaChecker.isInArea(validator.getX(), validator.getY(), validator.getR()));
//    }
//
//    static Stream<Validator> checkBottomLeft_True() {
//        return Stream.of(
//                new Validator(new DirtyPoint("-1", "-1", "4")),
//                new Validator(new DirtyPoint("-1", "-1.5", "5")),
//                new Validator(new DirtyPoint("-2", "-0.5", "5")),
//                new Validator(new DirtyPoint("-2", "0", "4"))
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    @SneakyThrows
//    public void checkBottomLeft_True(Validator validator) {
//        validator.validate();
//        assertTrue(AreaChecker.isInArea(validator.getX(), validator.getY(), validator.getR()));
//    }
//
//    static Stream<Validator> checkBottomLeft_False() {
//        return Stream.of(
//                new Validator(new DirtyPoint("-1", "-0.001", "2")),
//                new Validator(new DirtyPoint("-1", "-2", "3")),
//                new Validator(new DirtyPoint("-3", "-5", "5"))
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    @SneakyThrows
//    public void checkBottomLeft_False(Validator validator) {
//        validator.validate();
//        assertFalse(AreaChecker.isInArea(validator.getX(), validator.getY(), validator.getR()));
//    }
//
//    static Stream<Validator> checkBottomRight_False() {
//        return Stream.of(
//                new Validator(new DirtyPoint("1", "-2", "3")),
//                new Validator(new DirtyPoint("2", "-0.001", "2.99")),
//                new Validator(new DirtyPoint("4", "-5", "4"))
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource
//    @SneakyThrows
//    public void checkBottomRight_False(Validator validator) {
//        validator.validate();
//        assertFalse(AreaChecker.isInArea(validator.getX(), validator.getY(), validator.getR()));
//    }
//}
