package model;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import se.ifmo.web.hard_lab2.dto.DirtyPoint;
import se.ifmo.web.hard_lab2.dto.Point;
import se.ifmo.web.hard_lab2.exceptions.InvalidDataExceptions;
import se.ifmo.web.hard_lab2.model.Validator;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    @Test
    public void ownTest() throws InvalidDataExceptions {
        DirtyPoint dirtyPoint = new DirtyPoint("-1", "2", "3");
        Point point = new Validator(dirtyPoint).validate();
        System.out.println(point);
        assertNotNull(point);
    }

//    private Validator validator;
//
//    private void beforeXTests(String x) {
//        DirtyPoint dirtyPoint = new DirtyPoint(x, null, null);
//        validator = new Validator(dirtyPoint);
//    }
//
//    @SneakyThrows
//    @ParameterizedTest
//    @ValueSource(strings = {"-4", "-3", "-2", "-1", "0", "1", "2", "3", "4"})
//    public void xSimpleValue_OK(String x) {
//        // given
//        beforeXTests(x);
//
//        // when
//        validator.checkX();
//
//        // then
//        assertEquals(validator.getX(), Integer.parseInt(x));
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"-5", "123", "6", "5", "-12", "0,12", "0.5", "0e2"})
//    public void xBadInteger_InvalidDataExceptions(String x) {
//        // given
//        beforeXTests(x);
//
//        // when/then
//        assertThrows(InvalidDataExceptions.class, validator::checkX);
//    }
//
//    @ParameterizedTest
//    @NullAndEmptySource
//    public void xNullAndEmpty_InvalidDataExceptions(String x) {
//        // given
//        beforeXTests(x);
//
//        // when/then
//        assertThrows(InvalidDataExceptions.class, validator::checkX);
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"-1232122", "0,00000012"})
//    public void xLongInteger_InvalidDataExceptions(String x) {
//        // given
//        beforeXTests(x);
//
//        // when/then
//        assertThrows(InvalidDataExceptions.class, validator::checkX);
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"-3we", "2e2", "0,2d"})
//    public void xNotInteger_InvalidDataExceptions(String x) {
//        // given
//        beforeXTests(x);
//
//        // when/then
//        assertThrows(InvalidDataExceptions.class, validator::checkX);
//    }
//
//    private void beforeYTests(String y) {
//        DirtyPoint dirtyPoint = new DirtyPoint(null, y, null);
//        validator = new Validator(dirtyPoint);
//    }
//
//    @SneakyThrows
//    @ParameterizedTest
//    @ValueSource(strings = {"-5", "5", "0", "0,12", "0.12", "4,9999", "0e12", "3e0", "2,234", "-3E0", "  4 "})
//    public void yGoodNumber_OK(String y) {
//        // given
//        beforeYTests(y);
//
//        // when
//        validator.checkY();
//
//        // then
//        assertEquals(Double.parseDouble(y.replaceAll(",", ".")), validator.getY());
//    }
//
//    @ParameterizedTest
//    @NullAndEmptySource
//    public void yNullAndEmpty_InvalidDataExceptions(String y) {
//        // given
//        beforeYTests(y);
//
//        // when/then
//        assertThrows(InvalidDataExceptions.class, validator::checkY);
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"1221323", "-0,1234", "5555555", "0e122321"})
//    public void yLongNumber_InvalidDataExceptions(String y) {
//        // given
//        beforeYTests(y);
//
//        // when/then
//        assertThrows(InvalidDataExceptions.class, validator::checkY);
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"--0,1", "-0.12w1", "qewcec", "0r1"})
//    public void yBadFloat_InvalidDataExceptions(String y) {
//        // given
//        beforeYTests(y);
//
//        // when/then
//        assertThrows(InvalidDataExceptions.class, validator::checkY);
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"-6", "6", "12", "-10"})
//    public void yBigOrSmallFloat_InvalidDataExceptions(String y) {
//        // given
//        beforeYTests(y);
//
//        // when/then
//        assertThrows(InvalidDataExceptions.class, validator::checkY);
//    }
//
//    private void beforeRTests(String r) {
//        DirtyPoint dirtyPoint = new DirtyPoint(null, null, r);
//        validator = new Validator(dirtyPoint);
//    }
//
//    @SneakyThrows
//    @ParameterizedTest
//    @ValueSource(strings = {"2", "5", "3,12", "2.125", "4,9999", "3e0", "4,234", "5E0"})
//    public void rGoodNumber_OK(String r) {
//        // given
//        beforeRTests(r);
//
//        // when
//        validator.checkR();
//
//        // then
//        assertEquals(Double.parseDouble(r.replaceAll(",", ".")), validator.getR());
//    }
//
//    @ParameterizedTest
//    @NullAndEmptySource
//    public void rNullAndEmpty_InvalidDataExceptions(String r) {
//        // given
//        beforeRTests(r);
//
//        // when/then
//        assertThrows(InvalidDataExceptions.class, validator::checkR);
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"1221323", "-2,1234", "5555555", "0e122321"})
//    public void rLongNumber_InvalidDataExceptions(String r) {
//        // given
//        beforeRTests(r);
//
//        // when/then
//        assertThrows(InvalidDataExceptions.class, validator::checkR);
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"--3,1", "-4.12w1", "qewcec", "2r1"})
//    public void YBadFloat_InvalidDataExceptions(String r) {
//        // given
//        beforeRTests(r);
//
//        // when/then
//        assertThrows(InvalidDataExceptions.class, validator::checkR);
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"1", "6", "0", "-10", "11"})
//    public void YBigOrSmallFloat_InvalidDataExceptions(String r) {
//        // given
//        beforeRTests(r);
//
//        // when/then
//        assertThrows(InvalidDataExceptions.class, validator::checkR);
//    }
//
//    @Test
//    @SneakyThrows
//    public void validateAll_OK() {
//        // given
//        DirtyPoint dirtyPoint = new DirtyPoint("-3", "0,942", "2.55");
//        validator = new Validator(dirtyPoint);
//
//        // when
//        validator.validate();
//
//        // then
//        assertAll(
//                () -> assertEquals(-3, validator.getX()),
//                () -> assertEquals(0.942, validator.getY()),
//                () -> assertEquals(2.55, validator.getR())
//        );
//    }
//
//    @ParameterizedTest
//    @CsvSource(value={
//            "-8, 0.942, 2.55",
//            "-3, 9.942, 2.55",
//            "-3, 0.942, 9.55",
//            "-8, 0.942, 9.55",
//            "-21, 2.d942, 1-.55",
//    })
//    public void validateAllBadParams_InvalidDataExceptions(String x, String y, String r) {
//        // given
//        DirtyPoint dirtyPoint = new DirtyPoint(x, y, r);
//        validator = new Validator(dirtyPoint);
//
//        // when/then
//        assertThrows(InvalidDataExceptions.class, validator::validate);
//    }
}
