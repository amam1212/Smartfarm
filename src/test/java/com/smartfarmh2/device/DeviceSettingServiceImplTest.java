//package com.smartfarmh2.device;
//
//
//
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//
///**
// * Created by DELL on 7/22/2016.
// */
//
//public class DeviceSettingServiceImplTest {
//
//    @Test
//    public void list(){
//        DeviceSettingServiceImpl deviceSettingService = mock(DeviceSettingServiceImpl.class);
//        Device device1 = new Device(1l,"Device1");
//        DeviceSetting devicesetting = new DeviceSetting(1l,device1,1205.0,1304.0);
//        {
//            List<DeviceSetting> returnMock = new ArrayList<>();
//            returnMock.add(devicesetting);
//            when(deviceSettingService.list()).thenReturn(returnMock);
//        }
//
//        List<DeviceSetting> resultSuccess = deviceSettingService.list();
//        assertEquals(deviceSettingService.list(),resultSuccess);
//        assertNotNull(resultSuccess);
//        System.out.println(resultSuccess);
//
//        System.out.println("=================================================");
//        System.out.println("In case of empty database...");
//        List<DeviceSetting> devicelist = new ArrayList<>();
//        when(devicelist).thenReturn(null);
//        List<DeviceSetting> resultFailed1 = deviceSettingService.list();
//        assertNull(resultFailed1);
//        System.out.println(resultFailed1);
//
//    }
//
//    @Test
//    public void create(){
//        DeviceSettingServiceImpl deviceSettingService = mock(DeviceSettingServiceImpl.class);
//        Device device1 = new Device(1l,"Device1");
//        Device device2 = new Device(2l,"Device2");
//        DeviceSetting devicesetting1 = new DeviceSetting(1l,device2,1205.0,1304.0);
//        DeviceSetting devicesetting2 = new DeviceSetting(2l,device2,1305.0,1400.0);
//        {
//            DeviceSetting returnMock = new DeviceSetting(2l,device2,1305.0,1400.0);
//            when(deviceSettingService.create(devicesetting2)).thenReturn(returnMock);
//        }
//
//        DeviceSetting resultSuccess = deviceSettingService.create(devicesetting2);
//    assertEquals(devicesetting2.getId(),resultSuccess.getId());
//    assertNotNull(resultSuccess);
//    System.out.println(resultSuccess);
//
//        System.out.println("=================================================");
//        System.out.println("In case of some of empty data...");
//        DeviceSetting devicesetting3 = new DeviceSetting(2l,null,1500,1600.0);
//        when(deviceSettingService.create(devicesetting3)).thenReturn(null);
//        DeviceSetting resultFailed1 = deviceSettingService.create(devicesetting3);
//        assertNull(resultFailed1);
//        System.out.println(resultFailed1);
//
//    }
//
//    @Test
//    public void getDevice (){
//        DeviceSettingServiceImpl deviceSettingService = mock(DeviceSettingServiceImpl.class);
//        Device device1 = new Device(1l,"Device1");
//        DeviceSetting devicesetting1 = new DeviceSetting(1l,device1,1205.0,1304.0);
//        {
//            DeviceSetting returnMock = new DeviceSetting(1l,device1,1205.0,1304.0);
//            when(deviceSettingService.getDeviceSetting(1l)).thenReturn(returnMock);
//        }
//
//        DeviceSetting resultSuccess = deviceSettingService.getDeviceSetting(1l);
//        assertEquals(devicesetting1.getId(),resultSuccess.getId());
//        assertNotNull(resultSuccess);
//        System.out.println(resultSuccess);
//
//        System.out.println("=================================================");
//        System.out.println("In case of unmatched id...");
//        when(deviceSettingService.getDeviceSetting(4l)).thenReturn(null);
//        DeviceSetting resultFailed1 = deviceSettingService.getDeviceSetting(4l);
//        assertNull(resultFailed1);
//        System.out.println(resultFailed1);
//
//    }
//
//    @Test
//    public void delete (){
//        DeviceSettingServiceImpl deviceSettingService = mock(DeviceSettingServiceImpl.class);
//        Device device1 = new Device(1l,"Device1");
//        DeviceSetting devicesetting1 = new DeviceSetting(1l,device1,1205.0,1304.0);
//
//        List<DeviceSetting> returnMock = new ArrayList<>();
//        returnMock.add(devicesetting1);
//
//
//
//        deviceSettingService.delete(1l);
//        if (!returnMock.contains(1l)) {
//            System.out.println("There is no 3l data");
//        }
//
//        System.out.println("=================================================");
//        System.out.println("In case of unmatched id....");
//        deviceSettingService.delete(5l);
//        if (!returnMock.contains(1l)) {
//            System.out.println("There are all data");
//        }
//
//    }
//
//}
