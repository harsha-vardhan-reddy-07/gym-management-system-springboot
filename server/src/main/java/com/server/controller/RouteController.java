package com.server.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.server.models.EquipmentModel;
import com.server.models.MonthlyPlansModel;
import com.server.models.SubscriptionsModel;
import com.server.models.UsersModel;
import com.server.models.WorkoutPlansModel;
import com.server.models.WorkoutSubscriptionsModel;
import com.server.repos.EquipmentRepo;
import com.server.repos.MonthlyPlansRepo;
import com.server.repos.SubscriptionsRepo;
import com.server.repos.UsersRepo;
import com.server.repos.WorkoutPlansRepo;
import com.server.repos.WorkoutSubscriptionsRepo;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@Controller
public class RouteController {

    @Autowired
    EquipmentRepo equipmentRepo;

    @Autowired
    MonthlyPlansRepo monthlyPlansRepo;

    @Autowired
    SubscriptionsRepo subscriptionsRepo;

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    WorkoutPlansRepo workoutPlansRepo;

    @Autowired
    WorkoutSubscriptionsRepo workoutSubscriptionsRepo;


    @PostMapping("/register")
    public UsersModel registerMethod(@RequestBody UsersModel userData) {
        try {
            UsersModel user = usersRepo.save(userData);
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/login")
    public UsersModel loginMethod(@RequestBody UsersModel userData) {
        try {
            UsersModel user = usersRepo.findByEmail(userData.getEmail());
            if (user.getPassword().equals(userData.getPassword())) {

                return user;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }


    @GetMapping("/fetch-users")
    public List<UsersModel> fetchUsers() {
        try {

            List<UsersModel> users = usersRepo.findAll();
            return users;

        } catch (Exception e) {
            return null;
        }
    }


    @GetMapping("/fetch-user/{id}")
    public UsersModel fetchUser(@PathVariable("id") String id) {
        try {
            UsersModel user = usersRepo.findById(id).get();
            return user;
        } catch (Exception e) {
            return null;
        }
    }


    @GetMapping("/fetch-equipment")
    public List<EquipmentModel> fetchEquipment() {
        try {
            List<EquipmentModel> equipment = equipmentRepo.findAll();
            return equipment;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/add-equipment")
    public EquipmentModel addEquipment(@RequestBody EquipmentModel equipmentData) {
        try {
            EquipmentModel equipment = equipmentRepo.save(equipmentData);
            return equipment;
        } catch (Exception e) {
            return null;
        }
    }

    // @PostMapping("/update-equipment-quantity/{id}")
    // public EquipmentModel updateEquipmentQuantity(@PathVariable("id") String id ,@RequestBody EquipmentModel equipmentData) {
    //     try {
    //         EquipmentModel equipment = equipmentRepo.findById(id).get();
    //         equipment.setQuantity(equipmentData.getQuantity());
    //         equipmentRepo.save(equipment);
    //         return equipment;
    //     } catch (Exception e) {
    //         return null;
    //     }
    // }

    @DeleteMapping("/delete-equipment/{id}")
    public String deleteEquipment(@PathVariable("id") String id) {
        try {
            equipmentRepo.deleteById(id);
            return "Equipment Deleted";
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fetch-workout-plans")
    public List<WorkoutPlansModel> fetchWorkoutPlans() {
        try {
            List<WorkoutPlansModel> workouts = workoutPlansRepo.findAll();
            return workouts;
        } catch (Exception e) {
            return null;
        }
    }


    @PostMapping("/add-workout-plan")
    public WorkoutPlansModel addWorkoutPlan(@RequestBody WorkoutPlansModel workoutData) {
        try {
            WorkoutPlansModel workout = workoutPlansRepo.save(workoutData);
            return workout;
        } catch (Exception e) {
            return null;
        }
    }


    @GetMapping("/fetch-workout-plan/{id}")
    public WorkoutPlansModel fetchWorkoutPlan(@PathVariable("id") String id) {
        try {
            WorkoutPlansModel workout = workoutPlansRepo.findById(id).get();
            return workout;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fetch-workout-subscriptions")
    public List<WorkoutSubscriptionsModel> fetchWorkoutSubscriptions() {
        try {
            List<WorkoutSubscriptionsModel> subscriptions = workoutSubscriptionsRepo.findAll();
            return subscriptions;
        } catch (Exception e) {
            return null;
        }
    }

   
    @DeleteMapping("/delete-workout-plan/{id}")
    public String deleteWorkoutPlan(@PathVariable("id") String id) {
        try {
            workoutPlansRepo.deleteById(id);
            return "Workout Plan Deleted";
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/join-workout-plan")
    public String joinWorkoutPlan(@RequestBody WorkoutSubscriptionsModel subscriptionData) {
        try {

            UsersModel user = usersRepo.findById(subscriptionData.getUserId()).get();
            
            user.getWorkoutPlan().add(subscriptionData.getPlanId());

            

            WorkoutPlansModel workout = workoutPlansRepo.findById(subscriptionData.getPlanId()).get();

            workout.getSubscribers().add(subscriptionData.getUserId());

           

            WorkoutSubscriptionsModel subscription = new WorkoutSubscriptionsModel();


            subscription.setUserId(subscriptionData.getUserId());
            subscription.setUsername(user.getUsername());
            subscription.setEmail(user.getEmail());
            subscription.setPlanId(subscriptionData.getPlanId());
            subscription.setTitle(workout.getTitle());
            subscription.setTargetMuscles(workout.getTargetMuscles());
            subscription.setTrainerId(workout.getTrainerId());
            subscription.setTrainer(workout.getTrainer());
            subscription.setDuration(workout.getDuration());

            Date date = Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
            String strDate = dateFormat.format(date);  

            subscription.setStartDate(strDate);

            Number n = workout.getDuration();
            long l = n.longValue();
            LocalDate localDate = LocalDate.now().plusDays(l);
            subscription.setEndDate(localDate.toString());

            workoutSubscriptionsRepo.save(subscription);

            usersRepo.save(user);
            workoutPlansRepo.save(workout);

            return "Workout Plan Joined";
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/finish-workout-plan/{id}")
    public String finishWorkoutPlan(@PathVariable("id") String id, @RequestBody SubscriptionsModel subData) {
        try {
            System.out.println(subData.getUserId());
            System.out.println(id);
            WorkoutPlansModel workout = workoutPlansRepo.findById(id).get();

            workout.getSubscribers().remove(subData.getUserId());
            workoutPlansRepo.save(workout);

            return "Workout Plan Finished";
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/discontinue-workout-plan/{id}")
    public String discontinueWorkoutPlan(@PathVariable("id") String id, @RequestBody WorkoutSubscriptionsModel subData) {
        try {
            WorkoutPlansModel workout = workoutPlansRepo.findById(id).get();

            workout.getSubscribers().remove(subData.getUserId());

            workoutPlansRepo.save(workout);

            return "Workout Plan Discontinued";
        } catch (Exception e) {
            return null;
        }
    }


    @GetMapping("/fetch-monthly-plans")
    public List<MonthlyPlansModel> fetchMonthlyPlans() {
        try {
            List<MonthlyPlansModel> monthlyPlans = monthlyPlansRepo.findAll();
            return monthlyPlans;
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/fetch-subscriptions")
    public List<SubscriptionsModel> fetchSubscriptions() {
        try {
            List<SubscriptionsModel> subscriptions = subscriptionsRepo.findAll();
            return subscriptions;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/add-monthly-plan")
    public MonthlyPlansModel addMonthlyPlan(@RequestBody MonthlyPlansModel monthlyData) {
        try {
            MonthlyPlansModel monthlyPlan = monthlyPlansRepo.save(monthlyData);
            return monthlyPlan;
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/update-monthly-plan/{id}")
    public MonthlyPlansModel updateMonthlyPlan(@PathVariable("id") String id, @RequestBody MonthlyPlansModel monthlyData) {
        try {
            MonthlyPlansModel monthlyPlan = monthlyPlansRepo.findById(id).get();

            monthlyPlan.setTitle(monthlyData.getTitle());
            monthlyPlan.setDescription(monthlyData.getDescription());
            monthlyPlan.setImage(monthlyData.getImage());
            monthlyPlan.setAmount(monthlyData.getAmount());
            monthlyPlan.setDuration(monthlyData.getDuration());

            monthlyPlansRepo.save(monthlyPlan);
            return monthlyPlan;
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/delete-monthly-plan/{id}")
    public String deleteMonthlyPlan(@PathVariable("id") String id) {
        try {
            monthlyPlansRepo.deleteById(id);
            return "Monthly Plan Deleted";
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/join-monthly-plan")
    public String joinMonthlyPlan(@RequestBody SubscriptionsModel subscriptionData) {
        try {

            UsersModel user = usersRepo.findById(subscriptionData.getUserId()).get();

            MonthlyPlansModel monthlyPlan = monthlyPlansRepo.findById(subscriptionData.getPlanId()).get();

            monthlyPlan.getSubscribers().add(subscriptionData.getUserId());

            monthlyPlansRepo.save(monthlyPlan);

            SubscriptionsModel subscription = new SubscriptionsModel();

            subscription.setUserId(subscriptionData.getUserId());
            subscription.setUsername(user.getUsername());
            subscription.setEmail(user.getEmail());

            subscription.setPlanId(subscriptionData.getPlanId());
            subscription.setPlanTitle(monthlyPlan.getTitle());
            subscription.setPlanAmount(monthlyPlan.getAmount());

            Date date = Calendar.getInstance().getTime();  
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
            String strDate = dateFormat.format(date);  

            subscription.setStartDate(strDate);

            Number n = monthlyPlan.getDuration();
            long l = n.longValue();
            LocalDate localDate = LocalDate.now().plusDays(l);
            subscription.setEndDate(localDate.toString());

            subscriptionsRepo.save(subscription);

            return "Monthly Plan Joined";
        } catch (Exception e) {
            return null;
        }
    }

    @DeleteMapping("/remove-subscription/{id}")
    public String removeSubscription(@PathVariable("id") String id, @RequestBody SubscriptionsModel subData) {
        try {
            
            SubscriptionsModel subscription = subscriptionsRepo.findById(id).get();
            
            MonthlyPlansModel monthlyPlan = monthlyPlansRepo.findById(subscription.getPlanId()).get();
            monthlyPlan.getSubscribers().remove(subscription.getUserId());
            monthlyPlansRepo.save(monthlyPlan);


            UsersModel user = usersRepo.findById(subscription.getUserId()).get();
            user.setSubscription("");
            usersRepo.save(user);

            subscriptionsRepo.deleteById(subscription.get_id());

            return "Subscription Removed";
        } catch (Exception e) {
            return null;
        }
    }









    
}
