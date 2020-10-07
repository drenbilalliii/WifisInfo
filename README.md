# Wifis Information
this is a simple program where through the Runtime class we execute commands to get information about the networks we were previously 
connected by showing the name, password and some other information.
# How does the program work
What the program does is once it finds all the network names that are connected via the command (netsh wlan show profiles)
Then these results are returned in a list, where we make the method where we iterate in each network (netsh wlan show profile {wifiName} key = clear)
and from each iteration we obtain information on that network
