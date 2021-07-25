# **Dark Fire**

**What it does:** Basically it's a fire alarming app.This app recieves temparature data(in centigrade) from remote sensors.
              Sensor data are sent to the app through internet by an IoT device.The data keep updating itself within ~10 seconds.A fixed
              temparature is set into the app.When the collected temperature crosses this limit,the alarm starts ringing.An option is given 
              for the users that they can call fire-station directly from this app.

**Features:** 
          
          - Account creation

          - Multiple Device Support for Each Account
          
          - Real Time Data Upadate
          
          - Automatic Alarm with Device Information
          
          - Calling Option to Fire Station
          
**Platform/Language:** 

          - Android Studio (for app building)
          
          - Arduino (for IoT platform programming)
          
          - Google Firebase (for real time remote data handling)
          
**Data Flow:** _Sensor -> IoT device -> [Internet] -> Firebase Real Time DB -> [Internet] -> App_

**Needed Hardware:** 

                 - LM35 (Temperature Sensor)
                 - NodeMCU (IoT Platform)
                 - Wires

**Limitatios:** 

            - One IoT device is needed here to transmit data of one sensor.It'll be very costly for the users.
            - Hardware installation is difficult.Experts are needed here to install all those staffs.
            - Fire Station calling option is quite manual.The dialing number is given into the code.This is not the optimized way.
            - Users cannot update their own and device info from the app.
            
**Conclusion:** Although the app is not very user friendly,it is fully functional.Many upgradation is possible in this app.
            Project related all files are uploaded here.Thanks for reading.Happy Coding! :)
          
                     
