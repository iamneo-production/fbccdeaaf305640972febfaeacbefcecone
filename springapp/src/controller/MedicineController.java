package com.example.pharmacy.controller;

import com.example.pharmacy.model.Medicine;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicineController {
    private List<Medicine> medicineList = new ArrayList<>();

    @PostMapping
    public boolean addMedicine(@RequestBody Medicine medicine) {
        return medicineList.add(medicine);
    }

    @PutMapping("/{medicineId}")
    public Medicine updateMedicine(@PathVariable int medicineId, @RequestBody Medicine updatedMedicine) {
        for (Medicine medicine : medicineList) {
            if (medicine.getMedicineId() == medicineId) {
                medicine.setMedicineName(updatedMedicine.getMedicineName());
                medicine.setPrice(updatedMedicine.getPrice());
                medicine.setQuantity(updatedMedicine.getQuantity());
                medicine.setDescription(updatedMedicine.getDescription());
                return medicine;
            }
        }
        return null;
    }
}
