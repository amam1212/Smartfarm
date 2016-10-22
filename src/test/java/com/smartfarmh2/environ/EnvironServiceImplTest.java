//package com.smartfarmh2.environ;
//
//import com.smartfarmh2.product.Product;
//import com.smartfarmh2.product.ProductServiceImpl;
//import org.junit.Test;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import static junit.framework.TestCase.assertFalse;
//import static junit.framework.TestCase.assertTrue;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//public class EnvironServiceImplTest {
//
//    @Test
//    public void lsit(){
//        EnvironServiceImpl environService = mock(EnvironServiceImpl.class);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        String str1 = "2016-08-16 12:30";
//        String str2 = "2016-08-16 12:31";
//        String str3 = "2016-08-16 12:32";
//        String str4 = "2016-08-16 12:32";
//        LocalDateTime dateTime1 = LocalDateTime.parse(str1, formatter);
//        LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
//        LocalDateTime dateTime3 = LocalDateTime.parse(str3, formatter);
//
//
//
//        Environ environOne = new Environ(1l,20.0,25.0,1500.0,dateTime1);
//        Environ environTwo = new Environ(2l,24.0,26.0,1350.0,dateTime2);
//        Environ environThree = new Environ(3l,23.0,21.0,1400.0,dateTime3);
//
////        Environ environOne = mock(Environ.class);
////        Environ environTwo = mock(Environ.class);
////        Environ environThree = mock(Environ.class);
////        when(environOne.getHumid()).thenReturn(20.0);
////        when(environOne.getSoil()).thenReturn(25.0);
////        when(environOne.getTemp()).thenReturn(1500.0);
////        when(environTwo.getHumid()).thenReturn(24.0);
////        when(environTwo.getSoil()).thenReturn(26.0);
////        when(environTwo.getTemp()).thenReturn(1350.0);
////        when(environThree.getHumid()).thenReturn(23.0);
////        when(environThree.getSoil()).thenReturn(21.0);
////        when(environThree.getTemp()).thenReturn(1400.0);
//
//        {
//            List<Environ> returnMock = new ArrayList<Environ>();
//            returnMock.add(environOne);
//            returnMock.add(environTwo);
//            returnMock.add(environThree);
//            when(environService.list()).thenReturn(returnMock);
//        }
//
//        List<Environ> resultSuccess = environService.list();
//        assertEquals(environService.list(),resultSuccess);
//        assertNotNull(resultSuccess);
//        System.out.println(resultSuccess);
//
//    }
//
//    @Test
//    public void create(){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        String str1 = "2016-08-16 12:30";
//        String str2 = "2016-08-16 12:31";
//        String str3 = "2016-08-16 12:32";
//        String str4 = "2016-08-16 12:32";
//        LocalDateTime dateTime1 = LocalDateTime.parse(str1, formatter);
//        LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
//        LocalDateTime dateTime3 = LocalDateTime.parse(str3, formatter);
//        LocalDateTime dateTime4 = LocalDateTime.parse(str4, formatter);
//
//
//        EnvironServiceImpl environService = mock(EnvironServiceImpl.class);
//        Environ environOne = new Environ(1l,20.0,25.0,1500.0,dateTime1);
//        Environ environTwo = new Environ(2l,24.0,26.0,1350.0,dateTime2);
//        Environ environThree = new Environ(3l,23.0,21.0,1400.0,dateTime3);
//        Environ environFour = new Environ(4l,32.0,45.0,1200.0,dateTime4);
//        {
//            Environ returnMock = new Environ(4l,32.0,45.0,1200.0,dateTime4);
//            when(environService.create(environFour)).thenReturn(returnMock);
//        }
//
//        Environ resultSuccess = environService.create(environFour);
//        assertEquals(environFour,resultSuccess);
//        assertNotNull(resultSuccess);
//        System.out.println(resultSuccess);
//
//        System.out.println("=================================================");
//        System.out.println("In case of some of empty data...");
//        Environ environ1 = new Environ(4l,null,45.0,1200.0,dateTime4);
//        when(environService.create(environ1)).thenReturn(null);
//        Environ resultFailed1 = environService.create(environ1);
//        assertNull(resultFailed1);
//        System.out.println(resultFailed1);
//
//    }
//
//    @Test
//    public void getEnviron() {
//        EnvironServiceImpl environService = mock(EnvironServiceImpl.class);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        String str1 = "2016-08-16 12:30";
//        String str2 = "2016-08-16 12:31";
//        String str3 = "2016-08-16 12:32";
//        String str4 = "2016-08-16 12:32";
//        LocalDateTime dateTime1 = LocalDateTime.parse(str1, formatter);
//        LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
//        LocalDateTime dateTime3 = LocalDateTime.parse(str3, formatter);
//
//
//        Environ environOne = new Environ(1l, 20.0, 25.0, 1500.0, dateTime1);
//        Environ environTwo = new Environ(2l, 24.0, 26.0, 1350.0, dateTime2);
//        Environ environThree = new Environ(3l, 23.0, 21.0, 1400.0, dateTime3);
//        {
//            List<Environ> returnMock = new ArrayList<Environ>();
//            returnMock.add(environOne);
//            returnMock.add(environTwo);
//            returnMock.add(environThree);
//            when(environService.getEnviron(1l)).thenReturn(returnMock.get(0));
//        }
//
//        Environ resultSuccess = environService.getEnviron(1l);
//        assertEquals(environOne, resultSuccess);
//        assertNotNull(resultSuccess);
//        System.out.println(resultSuccess);
//
//        System.out.println("=================================================");
//        System.out.println("In case of unmatched id....");
//        when(environService.getEnviron(4L)).thenReturn(null);
//        Environ resultFailed1 = environService.getEnviron(4L);
//        assertNull(resultFailed1);
//        System.out.println(resultFailed1);
//
//    }
//
//    @Test
//    public void update(){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        String str1 = "2016-08-16 12:30";
//        String str2 = "2016-08-16 12:31";
//        String str3 = "2016-08-16 12:32";
//        String str4 = "2016-08-16 12:32";
//        LocalDateTime dateTime1 = LocalDateTime.parse(str1, formatter);
//        LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
//        LocalDateTime dateTime3 = LocalDateTime.parse(str3, formatter);
//        LocalDateTime dateTime4 = LocalDateTime.parse(str4, formatter);
//
//
//        EnvironServiceImpl environService = mock(EnvironServiceImpl.class);
//        Environ environOne = new Environ(1l,20.0,25.0,1500.0,dateTime1);
//        Environ environTwo = new Environ(2l,24.0,26.0,1350.0,dateTime2);
//        Environ environThree = new Environ(3l,23.0,21.0,1400.0,dateTime3);
//        Environ environFour = new Environ(1l,999.0,25.0,1500.0,dateTime1);
//        {
//            Environ returnMock = new Environ(1l,999.0,25.0,1500.0,dateTime1);
//            when(environService.update(environFour)).thenReturn(returnMock);
//        }
//
//        Environ resultSuccess = environService.update(environFour);
//        assertEquals(environFour.getTemp(),resultSuccess.getTemp());
//        assertNotNull(resultSuccess);
//        System.out.println(resultSuccess);
//
//        System.out.println("=================================================");
//        System.out.println("In case of some of empty data...");
//        Environ environ1 = new Environ(1l,null,45.0,1200.0,dateTime4);
//        when(environService.update(environ1)).thenReturn(null);
//        Environ resultFailed1 = environService.update(environ1);
//        assertNull(resultFailed1);
//        System.out.println(resultFailed1);
//
//    }
//
//    @Test
//    public void delete() {
//        EnvironServiceImpl environService = mock(EnvironServiceImpl.class);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        String str1 = "2016-08-16 12:30";
//        String str2 = "2016-08-16 12:31";
//        String str3 = "2016-08-16 12:32";
//        String str4 = "2016-08-16 12:32";
//        LocalDateTime dateTime1 = LocalDateTime.parse(str1, formatter);
//        LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
//        LocalDateTime dateTime3 = LocalDateTime.parse(str3, formatter);
//        LocalDateTime dateTime4 = LocalDateTime.parse(str4, formatter);
//
//
//        Environ environOne = new Environ(1l, 20.0, 25.0, 1500.0, dateTime1);
//        Environ environTwo = new Environ(2l, 24.0, 26.0, 1350.0, dateTime2);
//        Environ environThree = new Environ(3l, 23.0, 21.0, 1400.0, dateTime3);
//        Environ environFour = new Environ(4l, 999.0, 25.0, 1500.0, dateTime4);
//
//        List<Environ> environList = new ArrayList<>();
//        environList.add(environOne);
//        environList.add(environTwo);
//        environList.add(environThree);
//        environList.add(environFour);
//
//        environService.delete(4l);
//        if (!environList.contains(3l)) {
//            System.out.println("There is no 4l data");
//        }
//
//        System.out.println("=================================================");
//        System.out.println("In case of unmatched id....");
//        environService.delete(5l);
//        if (!environList.contains(3l)) {
//            System.out.println("There are all data");
//        }
//    }
//
//    @Test
//    public void findByCreatedDateBetween(){
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        String str1 = "2016-08-16 12:30";
//        String str2 = "2016-08-16 12:31";
//        String str3 = "2016-08-16 12:32";
//        String str4 = "2016-08-16 12:33";
//        LocalDateTime dateTime1 = LocalDateTime.parse(str1, formatter);
//        LocalDateTime dateTime2 = LocalDateTime.parse(str2, formatter);
//        LocalDateTime dateTime3 = LocalDateTime.parse(str3, formatter);
//        LocalDateTime dateTime4 = LocalDateTime.parse(str4, formatter);
//
//        List<Environ> returnMock = new ArrayList<>();
//        EnvironServiceImpl environService = mock(EnvironServiceImpl.class);
//        Environ environOne = new Environ(1l,20.0,25.0,1500.0,dateTime1);
//        Environ environTwo = new Environ(2l,24.0,26.0,1350.0,dateTime2);
//        Environ environThree = new Environ(3l,23.0,21.0,1400.0,dateTime3);
//        Environ environFour = new Environ(4l,999.0,25.0,1500.0,dateTime1);
//        {
//
//            returnMock.add(environOne);
//            returnMock.add(environTwo);
//            returnMock.add(environThree);
//            returnMock.add(environFour);
//
//            when(environService.findByCreatedDateBetween(dateTime1,dateTime4)).thenReturn(returnMock);
//        }
//
//        List<Environ> resultSuccess = environService.findByCreatedDateBetween(dateTime1,dateTime4);
//        assertEquals(returnMock,resultSuccess);
//        assertNotNull(resultSuccess);
//        System.out.println(resultSuccess);
//
//        System.out.println("=================================================");
//        System.out.println("In case of unmatched date...");
//        String str5 = "2016-08-16 12:40";
//        String str6 = "2016-08-16 12:59";
//        LocalDateTime dateTime5 = LocalDateTime.parse(str5, formatter);
//        LocalDateTime dateTime6 = LocalDateTime.parse(str6, formatter);
//        when(environService.findByCreatedDateBetween(dateTime5,dateTime6)).thenReturn(null);
//        List<Environ> resultFailed1 = environService.findByCreatedDateBetween(dateTime5,dateTime6);
//        assertNull(resultFailed1);
//        System.out.println(resultFailed1);
//
//    }
//}