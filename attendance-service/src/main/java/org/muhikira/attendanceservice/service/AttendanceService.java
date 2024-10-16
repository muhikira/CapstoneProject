package org.muhikira.attendanceservice.service;
import org.muhikira.attendanceservice.model.Attendance;
import org.muhikira.attendanceservice.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttendanceService {

   @Autowired
  private AttendanceRepository attendanceRepository;

   public List<Attendance> getAllAttendance() {
       return attendanceRepository.findAll();
   }
   public Attendance markAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
  }

}
