MyProjects
==========
STEP1:Design first page of your application-

1)Expand res folder,again expand layout folder there is an XML file with name activity_lets_chat open that file,open its graphical layout.

2)From the widgets column drag and drop button to the side,now drag and drop textView to the same place write text "Welcome to lets chat application".

3)Now open where it's code is written i.e activity_lets_chat in that you will see the code of button and text view comes automatically when you drag and drop the text and button.Now,adjust the button and text according to you by giving its cordinates from top or bottom or left or right as i give using layout_margin_top,layout_margin_right.
Also give id to button i.e "button1". Now give the image in it's background using android:background in lineraLayout tag and give oreintation value "vertical". 
 
When you will satisfy with design of your first page move to write it's code.

See Screen Shot 1. 



STEP2:Expand src folder,you will see a JAVA file name "LetsChatActivity" open it and don't delete any code from there continue your work from there only-

FIRST STATEMENT: the pacakage where  your project is stored.

SECOND STATEMENT: tells the pacakage you have to import,I import pacakages-
    2.1)intent
    2.2)button
    2.3)imageView
rest of the pacakages are imported automatically.

THIRD STATEMENT: class with your activity name which extends/inherits form Activity.

FOURTH STATEMENT:onCreate function which add the first page design of your appllication to this code.

FIFTH/SIXTH STATEMENT:sets the image you want to display on your first page i.e chat1.png.

SEVENTH/EIGHTH:display the image and your layout of that screen respectively in your mobile .

NINTH:add the propertis of the button in your code.

TENTH:set the function of button i.e what button should do when you click on it.

ELEVENTH:in onClick function you will move to next activity i.e BluetoothTypeActivity when you click on the button this you can do by using "intent" and start activity function will start next activity.



STEP3:Make next activity i.e BluetoothTypeActivity -

1)Follow the same steps as we follow to make our LetsChatActivity i.e make new android project give any name to it and when time comes to write activity name write name BluetoothTypeActivity and press finish button.

2)there is a folder with name of your project which you give it recently,expand that folder in src folder copy the java file and paste to your orginal android project i.e LetsChat in the src folder where LetsChatActivity file is stored.In the same way copy layout file of BluetoothTypeActivity and paste in the folder where layout file of LetsChatActivity is stored.And also copy the menu file of  BluetoothTypeActivity  and paste in menu folder of LetsChat.

when you done the above work open "Android Manifest file" in that write following code: 
<activity android:name=".BluetoothTypeActivity" >
</activity>

after-
<activity
            android:name=".LetsChatActivity"
            android:label="@string/title_activity_lets_chat" >
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
</activity> 

when you done save your work 

Now make the design of BluetoothTypeActivity in the same way as you did for LetsChat.
Drag and Drop three buttons which i named-
1)ON/OFF
2)Search Device
3)Check

and write text above them like-
1)Bluetooth
2)Find Device
3)Paired Devices

Now adjust the position of your text and buttons from the top and bottom by giving values as we did in LetsChat layout.And give id to three buttons as i give button2,button3,button4.

See Screen Shot 2.

Now go to source code of this activity in src folder-
Write the code to display the image you want to use on this page of your application i.e inner1.png as we did in Lets chat Activity.Give the function of three buttons what will they do when we click on them.

1)ON/OFF button take us to next activity BluetoothOnAcivity
2)Find device button take us to BluetoothListActivity
3)Check Device button button take us to Bluetooth Settings



STEP4:Make BluetoothOnActivity

1)Follow the same procedure as we did in LetsChatActivity and BluetoothTypeActivtiy to make this activity.

2)Copy and paste JAVA file ,layout file and menu file to your original project i.e LetsChat.

3)Open it's layout file i.e activity_bluetooth_on and make the design of this screen-drag and drop two radio button from the widget column and write text corresponding to those buttons i.e ON and OFF.And give id to these buttons button5 and button6.

See Screen Shot 3.

when you done save your work and move to write it's source code in src folder.

1)All the statements are same as we did before becoz we have to display layout of each page and display same image on our mobile screen.

2)Now,Insted of using buttons we use radioButtons becoz we put radio buttons in our layout,assign the function to these buttons when they click-By clicking ON radioButton we move to "EnableBluetoothActivity".And by clicking OFF radioButton we move to "DisabledBluetooth Activity".

NOTE:don't touch the menu file,if you want to display special menu to your mobile screen then you can make changes but i didn't make changes.



STEP5:Make EnableBluetoothActivity

1)Use same procedure to make this activity,and after copy and paste their files read next point.

2)Make layout of this activity as i made-drag text view and write text to it "Your Bluetooth is Successfully ON"  and drag button and write "Let's chat" on that button.

See Screen Shot 4.

3)Go to it's JAVA file,new statement is their BluetoothAdapter-whenever we work on Bluetooth we have to make an object of BluetoothAdapter i.e mBluetoothAdapter it checks that your mobile consist of bluetooth or not.To detect that we use condition if mBluetoothAdapter is null that means our mobile doesn't contain bluetooth and it print out message "Bluetooth not supported".If this condition is false then it enable bluetooth of your mobile phone through mBluetoothAdapter.enable() function.
The function of button shown on this screen discuss later.



STEP6:Make DisableBluetoothActivity

1)Use same procedure to make this activity,and after copy and paste their files read next point.

2)Make layout of this activity as i made-drag text view and write text to it "Your Bluetooth is Successfully OFF"  and drag button and write "Back" on that button.

See Screen Shot 5.

3)If you click on the OFF button then it will take you to this activity,in the source code of this activity we again make bluetoothAdapter object it will check Bluetooth enable in your phone if yes then it will disable it by using mBluetoothAdapter.disable().

Till now you are able to ON and OFF your mobile phone Bluetooth through your application,and this you can check on your android mobile phone.
 


STEP7:Make BluetoothSearchActivity

1)Use same procedure to make this activity,and after copy and paste their files read next point.

2)Layout of this activity is quite diffrent from other activities,here i use list view in which all the items will display in the form of list because i want all the detected device to shown in the list that's why i am using it.For making list view use listView tag as shown in that give id i.e myList and add further details to it as we did for making buttons or text before.

See Screen Shot 6.

3)Now,move to the source code of search activity-i make variable of ArrayAdapter i.e "btArrayAdapter"  i make it because all the device i am detecting from my bluetooth are to be stored in this ArrayAdapter.And i make object of listView i.e listDeviceFound to get the list of my devices,next statement is the use of object of ArrayAdapter the second parameter pass in it to select only one device for connection.

4)Register receiver function is used because before using the receiver to receive our device we have to register it."btArrayAdapter.clear()" function is used to clear the list once we use it,so that next time we begin our search then we can't see the devices which are there before but not now.
"startDiscovery()" function is main function which start discovery for the devices."setOnItemClickListener" is not working so don't bother about it.Instead of it we use something else which we discuss later.
We use "BroadcastReceiver" so that it can receive our bluetooth devices and give their name and address of the devices,"onRegisterDestroy()" function check that receiver is register or not.

This whole process help you to detect the devices from your mobile phone bluetooth.

NOTE:if you click on the search Button before switch ON your mobile phone Bluetooth you will 

See Screen Shot 7.
 


STEP8:After getting the list of active devices go back to the layout of BluetoothTypeActivity and click on the check button,then you will see the same devices list as you see before.Tap on the phone corresponding to the device through which you want to connect your phone.

Now i explain how we know the devices are connected thorough our application.

Make java file instead of activity and named it "BluetoothConnectivity.java".
The main point about this activity is "You can't connect two device with your application you can only check through this file that the devices are connected to each other or not". 

When we open it we see the class name same as our java file name in it we make variables TAG,D,names,UUID-the UUID variable is important because through this UUID variable only we can connect our devices successfully.If this UUID is not same for Server and Client who are sending and accepting connection request respectively then our connection lost.

Make object of BluetoothAdapter,Handler,AcceptThread,ConnectThread,ConnectedThread. 

In "BluetoothConnectivity()" function we make the BluetoothAdapter by using inbuilt function getDefaultAdapter() and provide values to other variables.
Now we make class "ConnectThread" which send connection request to other device and we call it server.Then we make objects of BluetoothSocket and BluetoothDevice.

Parameter in the function ConnectThread is the device through which you want to connect then we store our device in the object we made i.e mDevice and make temp variable of type BluetoothSocket and assign value to it is null.Now we make exception Handling in which we create rfcommSocket with UUID so that they can send connection request to other device and then assign temp value to mSocket.

For the request successfully complete we use function run in which we first cancel the discovery of further devices so that our connection speed will not affect by further discovering of devices and then try to connect the other device through "connect()" function if this function fails then we come into exception and close the socket and we restart the connectivity through "BluetoothConnectivity.this.start()".

After we get the connection we call "connected()" function by passing arguments socket and device through which we want to connect our device and in the "cancel()" function we close our socket.

Connect function:In this function we take the device as a parameter and check the status of connection
mConnectThread-check that thread is trying to connect
mConnectedThread-check that thread is already connected.
we make the new thread for the device and call the start function in which we accept the connection thread.

Connected function:same as we did in connect function but additional code is it handel the message which we send from one mobile to another mobile.By using the variable msg obtain mesage in that through mHandler and store the string which we type in the bundle object and get the device name to which we have to send the mesage through putString function and send the data to other device by "sendMesage()" function and set the state connected .

Make the class AcceptThread and make variable mServerSocket of type BluetoothServerSocket in the function AcceptThread make temp variable of of type BluetoothServerSocket and assign value to null.Through mBluetoothAdapter we listen the connection request from the other phone,then we check the status of connection and on behalf of that we accept the connection request,for that we apply the switch case which take particular action corresponding to each status of connection.

Make the class ConnectedThread and make variables mInputStream and mOutputStream of type InputStream and OutputStream respectively.Assign value null to their tempory variables tempIn and tempOut in the connectedThread function.Apply exception handling to get Input and output stream through "socket.getInputStream()" and "socket.getOutputStream()" respectively and store it in tempIn and tempOut variables.

The motive of getting input and output stream is tells the path through which our message will transfer to other phone.And the values which we get from the functions will be stored in the variables mInputStream and mOutputStream respectivtely.
Run function helps to send the message right to the target using "sendToTarget()" function.
