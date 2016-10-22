package com.smartfarmh2.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceSettingServiceImpl implements DeviceSettingService {
    @Autowired
    DeviceSettingDao deviceSettingDao;

    @Override
    public DeviceSetting create(DeviceSetting deviceSetting) {
        return deviceSettingDao.create(deviceSetting);
    }

    @Override
    public DeviceSetting update(DeviceSetting deviceSetting) {
        return deviceSettingDao.update(deviceSetting);
    }

    @Override
    public void delete(Long id) {
        deviceSettingDao.delete(id);
    }

    @Override
    public DeviceSetting getDeviceSetting(Long id) {
        return deviceSettingDao.getDeviceSetting(id);
    }

    @Override
    public List<DeviceSetting> list() {
        return deviceSettingDao.list();
    }
}
