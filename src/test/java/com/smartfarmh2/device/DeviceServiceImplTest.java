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
//public class DeviceServiceImplTest {
//
//    @Test
//    public void list(){
//        DeviceServiceImpl deviceService = mock(DeviceServiceImpl.class);
//        Device device1 = new Device(1l,"Device1");
//        Device device2 = new Device(2l,"Device2");
//        Device device3 = new Device(3l,"Device3");
//        {
//            List<Device> returnMock = new ArrayList<>();
//            returnMock.add(device1);
//            returnMock.add(device2);
//            returnMock.add(device3);
//            when(deviceService.list()).thenReturn(returnMock);
//        }
//
//        List<Device> resultSuccess = deviceService.list();
//        assertEquals(deviceService.list(),resultSuccess);
//        assertNotNull(resultSuccess);
//        System.out.println(resultSuccess);
//
//        System.out.println("=================================================");
//        System.out.println("In case of empty database...");
//        List<Device> devicelist = new ArrayList<>();
//        when(devicelist).thenReturn(null);
//        List<Device> resultFailed1 = deviceService.list();
//        assertNull(resultFailed1);
//        System.out.println(resultFailed1);
//
//    }
//
//    @Test
//    public void create(){
//        DeviceServiceImpl deviceService = mock(DeviceServiceImpl.class);
//        Device device1 = new Device(1l,"Device1");
//        {
//            Device returnMock = new Device(1l,"Device1");
//            when(deviceService.create(device1)).thenReturn(returnMock);
//        }
//
//    Device resultSuccess = deviceService.create(device1);
//    assertEquals(device1.getName(),resultSuccess.getName());
//    assertNotNull(resultSuccess);
//    System.out.println(resultSuccess);
//
//        System.out.println("=================================================");
//        System.out.println("In case of some of empty data...");
//        Device device2 = new Device(1l,null);
//        when(deviceService.create(device2)).thenReturn(null);
//        Device resultFailed1 = deviceService.create(device2);
//        assertNull(resultFailed1);
//        System.out.println(resultFailed1);
//
//    }
//
//    @Test
//    public void getDevice (){
//        DeviceServiceImpl deviceService = mock(DeviceServiceImpl.class);
//        Device device1 = new Device(1l,"Device1");
//        Device device2 = new Device(2l,"Device2");
//        Device device3 = new Device(3l,"Device3");
//        {
//            Device returnMock = new Device(2l,"Device2");
//            when(deviceService.getDevice(2l)).thenReturn(returnMock);
//        }
//
//        Device resultSuccess = deviceService.getDevice(2l);
//        assertEquals(device2.getName(),resultSuccess.getName());
//        assertNotNull(resultSuccess);
//        System.out.println(resultSuccess);
//
//        System.out.println("=================================================");
//        System.out.println("In case of unmatched id...");
//        when(deviceService.getDevice(4l)).thenReturn(null);
//        Device resultFailed1 = deviceService.getDevice(4l);
//        assertNull(resultFailed1);
//        System.out.println(resultFailed1);
//
//    }
//
//    @Test
//    public void delete (){
//        DeviceServiceImpl deviceService = mock(DeviceServiceImpl.class);
//        Device device1 = new Device(1l,"Device1");
//        Device device2 = new Device(2l,"Device2");
//        Device device3 = new Device(3l,"Device3");
//
//        List<Device> returnMock = new ArrayList<>();
//        returnMock.add(device1);
//        returnMock.add(device2);
//        returnMock.add(device3);
//
//
//
//        deviceService.delete(3l);
//        if (!returnMock.contains(3l)) {
//            System.out.println("There is no 3l data");
//        }
//
//        System.out.println("=================================================");
//        System.out.println("In case of unmatched id....");
//        deviceService.delete(5l);
//        if (!returnMock.contains(3l)) {
//            System.out.println("There are all data");
//        }
//
//    }
//
//}
