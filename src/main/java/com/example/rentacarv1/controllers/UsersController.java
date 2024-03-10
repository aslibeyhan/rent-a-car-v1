package com.example.rentacarv1.controllers;


import com.example.rentacarv1.core.utilities.results.DataResult;
import com.example.rentacarv1.core.utilities.results.Result;
import com.example.rentacarv1.services.abstracts.UserService;
import com.example.rentacarv1.services.dtos.requests.user.*;
import com.example.rentacarv1.services.dtos.responses.user.GetUserListResponse;
import com.example.rentacarv1.services.dtos.responses.user.GetUserResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@CrossOrigin
public class UsersController {
    private UserService userService;

    @GetMapping("/getAll")
    public DataResult<List<GetUserListResponse>> getAll(){
        return this.userService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<GetUserResponse> getById(@PathVariable int id){
        return this.userService.getById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Result add(@RequestBody @Valid() AddUserRequest addUserRequest){

        return this.userService.add(addUserRequest);
    }


    @PutMapping("/update")
    public Result update( @RequestBody @Valid() UpdateUserRequest updateUserRequest){
        return this.userService.update(updateUserRequest);
    }

    @DeleteMapping("/{id}")
    public Result delete( @PathVariable int id){

        return this.userService.delete(id);
    }
    @PutMapping("/{id}/updateEmail")
    public void updateEmail(@PathVariable int id, @RequestBody @Valid UpdateEmailRequest updateEmailRequest) {
        userService.updateEmail(id, updateEmailRequest);
    }

    @PutMapping("/{id}/updatePhoneNumber")
    public void updatePhoneNumber(@PathVariable int id, @RequestBody @Valid UpdateGsmRequest updateGsmRequest) {
        userService.updateGsm(id, updateGsmRequest);
    }

    @PutMapping("/{id}/updatePassword")
    public void updatePassword(@PathVariable int id, @RequestBody @Valid UpdatePasswordRequest updatePasswordRequest) {
        userService.updatePassword(id, updatePasswordRequest);
    }
    @PutMapping("/{id}/updateName")
    public void updateName(@PathVariable int id, @RequestBody @Valid UpdateNameRequest updateNameRequest) {
        userService.updateName(id, updateNameRequest);
    }
    @PutMapping("/{id}/updateSurname")
    public void updateSurname(@PathVariable int id, @RequestBody @Valid UpdateSurnameRequest updateSurnameRequest) {
        userService.updateSurname(id, updateSurnameRequest);
    }

}
