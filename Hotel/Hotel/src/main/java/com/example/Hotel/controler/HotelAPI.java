package com.example.Hotel.controler;

import com.example.Hotel.Repository.OwnerRepo;
import com.example.Hotel.model.Owner;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/Hotel")
public class HotelAPI {
    @Autowired
    public OwnerRepo ownerRepo;

   //INSERT
    @PostMapping("/Insert")
    public ResponseEntity<?>Add (@RequestBody Owner owner) {
        try {
            Owner owner1=ownerRepo.save(owner);
            return new ResponseEntity<>("inserted",HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Not inserted",HttpStatus.BAD_REQUEST);
        }
    }


  @GetMapping("/GetAll")
    public ResponseEntity<?>getAll(){
        try{
            List<Owner>ownerList=ownerRepo.findAll();

            if (ownerList.isEmpty()){
                return  new ResponseEntity<>("Not Data",HttpStatus.NOT_FOUND);

            }
            else {
                return new ResponseEntity<>(ownerList,HttpStatus.OK);
            }

        } catch(Exception non){
            return new ResponseEntity<>("NetworkError",HttpStatus.BAD_REQUEST);
        }

 }
    @GetMapping("/GETBYID/{Owner_id}")
    public Optional<Owner> getOwner(@PathVariable Integer Owner_id){
        return ownerRepo.findById(Owner_id);

    }
@DeleteMapping("/DELETE/{Owner_id}")
        public String deleteOwner(@PathVariable Integer Owner_id){
        Owner deleteOwner=ownerRepo.findById(Owner_id).get();
        ownerRepo.delete(deleteOwner);
        return "userDeleted";
}
@PutMapping("/Update/{Owner_id}")
    public String updateOwner(@PathVariable  Integer Owner_id,@RequestBody Owner owner){
        Owner updatedOwner =ownerRepo.findById(Owner_id).get();
        updatedOwner.setOwnerName(owner.getOwnerName());
        updatedOwner.setAdress(owner.getAdress());
        updatedOwner.setCountry(owner.getCountry());
        updatedOwner.setDate(owner.getDate());
        updatedOwner.setEmail(owner.getEmail());
        updatedOwner.setDocument_Type(owner.getDocument_Type());
        updatedOwner.setPhone(owner.getPhone());
        updatedOwner.setGender(owner.getGender());
        updatedOwner.setHotel_Name(owner.getHotel_Name());
        updatedOwner.setHotel_Adress(owner.getHotel_Adress());
        ownerRepo.save(updatedOwner);
        return "updated";

}
}


