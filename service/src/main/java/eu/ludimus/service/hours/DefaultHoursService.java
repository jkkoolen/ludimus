package eu.ludimus.service.hours;

import eu.ludimus.domain.entity.Hours;
import eu.ludimus.domain.entity.Action;
import eu.ludimus.domain.entity.User;
import eu.ludimus.domain.repository.HoursRepository;
import eu.ludimus.service.dto.HoursDto;
import eu.ludimus.service.dto.mapper.HoursDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public final class DefaultHoursService implements HoursService {
    @Autowired
    private HoursRepository hoursRepository;

    @Autowired
    private HoursDtoMapper hoursDtoMapper;

    @Transactional(readOnly = true)
    @Override
    public HoursDto findById(Long id) {
        return hoursDtoMapper.map(hoursRepository.findById(id));
    }

    @Transactional(readOnly = false)
    @Override
    public HoursDto save(HoursDto hours, User user, Action action) {
        return hoursDtoMapper.map(hoursRepository.save(hoursDtoMapper.map(hours, new Hours())));
    }

    @Transactional(readOnly = false)
    @Override
    public void delete(HoursDto hours) {
        hoursRepository.delete(hoursDtoMapper.map(hours, new Hours()));
    }

    @Override
    public HoursDto findStartedByUser(User user) {
        return hoursDtoMapper.map(hoursRepository.findByUserIdAndStartTimeIsNotNullAndEndTimeIsNull(user.getId()));
    }
}
