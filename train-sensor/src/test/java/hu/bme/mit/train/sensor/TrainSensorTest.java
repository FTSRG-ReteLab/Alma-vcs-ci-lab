package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import static org.mockito.Mockito.*;

public class TrainSensorTest {
	TrainController mockTC;
    TrainUser mockTU;
    TrainSensorImpl trainSensor;
    @Before
    public void before() {
    	mockTC = mock(TrainController.class);
        mockTU = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockTC, mockTU);
    }

    @Test
    public void AboveAbsoluteMargin() {
        trainSensorImpl.overrideSpeedLimit(501);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void UnderAbsoluteMargin() {
        trainSensorImpl.overrideSpeedLimit(-1);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void AbsoluteMargin() {
        trainSensorImpl.overrideSpeedLimit(4);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void RelativeMarginBetween() {
        trainSensorImpl.overrideSpeedLimit(300);
        verify(mockTrainUser, times(1)).setAlarmState(false);
    }
    
}
