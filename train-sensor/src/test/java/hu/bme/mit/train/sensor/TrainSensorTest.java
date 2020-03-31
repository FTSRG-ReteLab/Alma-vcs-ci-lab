package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {
    TrainController mockTrainController;
    TrainUser mockTrainUser;
    TrainSensorImpl trainSensorImpl;

    @Before
    public void before() {
        mockTrainController = mock(TrainController.class);
        mockTrainUser = mock(TrainUser.class);
        trainSensorImpl = new TrainSensorImpl(mockTrainController, mockTrainUser);
    }

    @Test
    public void AbsoluteMarginSuccess() {
        trainSensorImpl.overrideSpeedLimit(130);
        verify(mockTrainUser, times(1)).setAlarmState(false);
    }

    @Test
    public void AbsoluteMarginLowFail() {
        trainSensorImpl.overrideSpeedLimit(-100);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void AbsoluteMarginHighFail() {
        trainSensorImpl.overrideSpeedLimit(600);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void RelativeMarginSuccess() {
        trainSensorImpl.overrideSpeedLimit(7);
        verify(mockTrainUser, times(1)).setAlarmState(false);
    }

}
