package es.upm.grise.profunduzacion.cruiseController;

import es.upm.grise.profundizacion.cruiseControl.CruiseControl;
import es.upm.grise.profundizacion.cruiseControl.IncorrectSpeedSetException;
import es.upm.grise.profundizacion.cruiseControl.SpeedSetAboveSpeedLimitException;
import es.upm.grise.profundizacion.cruiseControl.Speedometer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CruiseControlTest {

    CruiseControl cruiseControl;
    static final int CURRENT_SPEED = 100;
    static final int SPEED_LIMIT = 120;

    @BeforeEach
    void setCruiseControl(){
        Speedometer speedometer = mock(Speedometer.class);
        cruiseControl = new CruiseControl(speedometer);
        //velocidad por defecto 100 km/h
        when(speedometer.getCurrentSpeed()).thenReturn(CURRENT_SPEED);
    }

    @Test
    public void validSpeedSet(){
        assertDoesNotThrow(() -> cruiseControl.setSpeedSet(60));
    }

    @Test
    public void speedSetCantBeNegativeOrCero(){
        assertThrows(IncorrectSpeedSetException.class, () -> cruiseControl.setSpeedSet(-10));
        assertThrows(IncorrectSpeedSetException.class, () -> cruiseControl.setSpeedSet(0));
    }

    @Test
    public void speedSetOverSpeedLimit() {
        cruiseControl.setSpeedLimit(SPEED_LIMIT);
        assertThrows(SpeedSetAboveSpeedLimitException.class, () -> cruiseControl.setSpeedSet(SPEED_LIMIT + 10));
    }

    @Test
    public void speedSetEqualsSpeedLimit() {
        cruiseControl.setSpeedLimit(SPEED_LIMIT);
        assertDoesNotThrow(() -> cruiseControl.setSpeedSet(SPEED_LIMIT));
    }





}
