package org.example.app.controller;

import org.example.app.entity.employee.Employee;
import org.example.app.network.ResponseData;
import org.example.app.network.ResponseMessage;
import org.example.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/employees")
    public ResponseData save(@RequestBody Employee employee) {
        Optional<Employee> optional = service.save(employee);
        return optional.map(value ->
                        new ResponseData(HttpStatus.CREATED.toString(),
                                true, value))
                .orElseGet(() ->
                        new ResponseData(HttpStatus.NO_CONTENT.toString(),
                                false,
                                ResponseMessage.SMTH_WRONG.getResMsg()));
    }

    @GetMapping("/employees")
    public ResponseData getAll() {
        Optional<List<Employee>> optional = service.getAll();
        return optional.map(employees ->
                new ResponseData(HttpStatus.OK.toString(),
                        true, employees))
                .orElseGet(() ->
                        new ResponseData(HttpStatus.NOT_FOUND.toString(),
                                false,
                                ResponseMessage.SMTH_WRONG.getResMsg()));
    }

    @GetMapping("/employees/{id}")
    public ResponseData getById(@PathVariable Long id) {
        Employee employee = service.getById(id);
        if (employee != null)
            return new ResponseData(HttpStatus.OK.toString(),
                    true, employee);
        else return new ResponseData(HttpStatus.NOT_FOUND.toString(),
                false, ResponseMessage.SMTH_WRONG.getResMsg());
    }

    @PutMapping("/employees/{id}")
    public ResponseData update(@PathVariable Long id,
                               @RequestBody Employee employee) {
        Employee employeeUpdated = service.update(id, employee);
        if (employeeUpdated != null)
            return new ResponseData(HttpStatus.OK.toString(),
                    true, employeeUpdated);
        else return new ResponseData(HttpStatus.NOT_FOUND.toString(),
                false, ResponseMessage.SMTH_WRONG.getResMsg());
    }

    @DeleteMapping("/employees/{id}")
    public ResponseData delete(@PathVariable Long id){
        if (service.delete(id))
            return new ResponseData(HttpStatus.OK.toString(),
                    true, ResponseMessage.DELETED.getResMsg());
        else return new ResponseData(HttpStatus.NOT_FOUND.toString(),
                false, ResponseMessage.SMTH_WRONG.getResMsg());
    }

    @GetMapping("/employees/first-name/{firstName}")
    public ResponseData getByFirstName(@PathVariable String firstName) {
        List<Employee> list = service.getByFirstName(firstName);
        if (!list.isEmpty())
            return new ResponseData(HttpStatus.OK.toString(),
                    true, list);
        else return new ResponseData(HttpStatus.NOT_FOUND.toString(),
                false, ResponseMessage.NO_DATA.getResMsg());
    }

    @GetMapping("/employees/last-name/{lastName}")
    public ResponseData getByLastName(@PathVariable String lastName) {
        List<Employee> list = service.getByLastName(lastName);
        if (!list.isEmpty())
            return new ResponseData(HttpStatus.OK.toString(),
                    true, list);
        else return new ResponseData(HttpStatus.NOT_FOUND.toString(),
                false, ResponseMessage.NO_DATA.getResMsg());
    }

    @GetMapping("/employees/position/{position}")
    public ResponseData getByPosition(@PathVariable String position) {
        List<Employee> list = service.getByPosition(position);
        if (!list.isEmpty())
            return new ResponseData(HttpStatus.OK.toString(),
                    true, list);
        else return new ResponseData(HttpStatus.NOT_FOUND.toString(),
                false, ResponseMessage.NO_DATA.getResMsg());
    }

    @GetMapping("/employees/phone/{phone}")
    public ResponseData getByPhoneNumber(@PathVariable String phone) {
        List<Employee> list = service.getByPhoneNumber(phone);
        if (!list.isEmpty())
            return new ResponseData(HttpStatus.OK.toString(),
                    true, list);
        else return new ResponseData(HttpStatus.NOT_FOUND.toString(),
                false, ResponseMessage.NO_DATA.getResMsg());
    }
}
