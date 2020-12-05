package com.jaenyeong.mission2.racingcar.domain;

import com.jaenyeong.mission2.racingcar.common.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("여러 차를 그룹화한 Cars 클래스 테스트")
class CarsTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("Cars 객체 초기화 시 주어진 숫자만큼 Car 객체가 생성되는지 확인하는 테스트")
    void carsInitWhenGivenTheNumberOfCars(final int randomValue) {
        final Cars cars = new Cars(randomValue);

        assertEquals(cars.getHowManyRacingCars(), randomValue);
    }

    @ParameterizedTest
    @MethodSource("randomIntValues")
    @DisplayName("Cars 객체의 moveRacingCars 메서드 호출시 각 Car 객체들의 이동 거리 확인 테스트")
    void checkMoveOfCars(final int randomValue) {
        final Cars cars = new Cars(randomValue);

        for (int i = 0; i < randomValue; i++) {
            cars.moveRacingCars();
        }

        final List<Integer> distanceOfCars = cars.getDistanceRacingCars();

        distanceOfCars.forEach(distOfCar -> assertThat(distOfCar).isBetween(0, randomValue));
    }
}
