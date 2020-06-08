package playground;
import java.util.ArrayList;
import java.util.Scanner;
public class system {
	public static void main (String[] args) {
		int k,searching=0,p,y=0,u=0,price;
		double account,size;
		boolean type =true;
		String name,password,email,phone,location,pin,free,_searching="0",back="0";
		 ArrayList<user> userlist= new ArrayList<user>();
		ArrayList<playground> playgroundlist = new ArrayList<playground>();
		ArrayList<player> playerlist=new ArrayList<player>();
		ArrayList<eWallet>eWalletlist=new ArrayList<eWallet>();
		ArrayList<playgroundowner>ownerlist=new ArrayList<playgroundowner>();
		do {
		System.out.println("1-signup"+"\n2-sign in" );
		Scanner myscanner = new Scanner(System.in);
		k=myscanner.nextInt();
		switch(k) {
		case 1:
			System.out.println("1-Signup as player"+"\n2-Signup as playgroundowner");
			do{
				k=myscanner.nextInt();
			    if(k==1||k==2)
			    	break;
			    else
			    	System.out.println("You entered invalid input please enter valid input: ");
			  }while(true);
			    user _user=new user();
				System.out.println("Enter your name: ");
				name=myscanner.nextLine();
				name=myscanner.nextLine();
				_user.setName(name);
				System.out.println("Enter your password: \t (password mustn`t contain space)");
				do {
				password=myscanner.nextLine();
				if(password.contains(" ")==true)
					System.out.println("You enterd invalid input!\t (password mustn`t contain space)");
				else
					break;	
				}while(true);
				_user.setPassword(password);
				System.out.println("Enter your e-mail: ");
				do {
					searching=0;
				   do {
					email=myscanner.nextLine();
					if(email.contains("@")==false||email.contains(" ")==true||email.contains(".")==false)
						System.out.println("please enter correct form of e_mai!(There must be @ and .and there mustn`t be space)!");
					else
						break;	
				    }while(true);
				   for(int i=0;i<userlist.size();i++) {
					   if(userlist.get(i).getEmail().equals(email)) {
						   searching++;
						   break;
					   }
					   else
						   continue;}
					   if(searching==0)
						  break;
					   else
						   System.out.println("This e-mail is used please enter another e-mail!");
				}while(true);
				_user.setEmail(email);
				System.out.println("Enter your location: ");
				location=myscanner.nextLine();
				_user.setLocation(location);
				System.out.println("Enter your phone: ");
				phone=myscanner.nextLine();
				_user.setPhone(phone);
				System.out.println("Your e-mail has been created successfully!");
				System.out.println("   eWallet System     ");
				eWallet _eWallet=new eWallet();
				System.out.println("Enter your accountnumber: ");
				account=myscanner.nextDouble();
				_eWallet.setAccount(account);
				System.out.println("Enter your password: ");
				pin=myscanner.nextLine();
				pin=myscanner.nextLine();
				_eWallet.setPin(pin);
				eWalletlist.add(_eWallet);
				_user.setWallet(_eWallet);
				if(k==1) {
					player _player=new player();
					 ArrayList<bookings> booking=new ArrayList<bookings>();	
					 _player.setBooking(booking);
					_player.setEmail(email);
					_player.setName(name);
					_player.setPhone(phone);
					_player.setPassword(password);
					_player.setLocation(location);
					_player.setWallet(_eWallet);
					_user.setType(true);
					playerlist.add(_player);
					}
				else {
					playgroundowner _owner=new playgroundowner();
					_owner.setEmail(email);
					_owner.setName(name);
					_owner.setPhone(phone);
					_owner.setPassword(password);
					_owner.setLocation(location);
					_owner.setWallet(_eWallet);
					_user.setType(false);
					ownerlist.add(_owner);
				}
				userlist.add(_user);
				System.out.println("Profile is created successfully!");
				break;
		case 2:
			System.out.println("Enter your e-mail: ");
			do {
		     searching=0;
		     email=myscanner.next();
			for(int i=0;i<userlist.size();i++) {
				if(userlist.get(i).getEmail().equals(email)) {
					searching++;
					_searching=userlist.get(i).getPassword();
					type=userlist.get(i).isType();
					if(type==true) {
					for(int h=0;h<playerlist.size();h++) {
						if(playerlist.get(h).getEmail().equals(email)) {
						y=h;
						break;
						}
						else
							continue;
						}
				           }
					else {
						for(int h=0;h<ownerlist.size();h++) {
							if(ownerlist.get(h).getEmail().equals(email)) {
								y=h;
								break;
							}
							else
								continue;
						                     }
						}
					break;
				}
			else
				continue;
				}
			if(searching==0)
				System.out.println("Invalid E-mail! please enter valid e-mail: ");
			else
				break;
			}while(true);
			System.out.println("Enter your password: ");
			do {
				searching=0;
				password=myscanner.next();
				if(password.equals(_searching))
					break;
				else
					System.out.println("Wrong password! Enter your password: ");
			}while(true);
			if(type==true) {
				do {
		
				System.out.println("1- View playgrounds"+"\n2- Creating team" + "\n3- View bookings" + "\n4- View favourite team" +"\n5- Check money in eWallet"+"\n6- view profile"+"\n7- log out");
				p=myscanner.nextInt();
				switch(p) {
				case 1:
					if(playgroundlist.size()==0)
						System.out.println("\t\t playgrounds \n\n There is no playgrounds!");
					else {
						System.out.println("\t\t playgounds \n\n");
					for(int i=0;i<playgroundlist.size();i++) {
						System.out.print((i+1)+"- ");
						System.out.println(playgroundlist.get(i).display()+"\n");
					}
					System.out.println("Choice playground: ");
					do {
						p=myscanner.nextInt();
						if(p>0&&p<=playgroundlist.size())
							break;
						else
							System.out.println("You entered invalid input please enter valid input: ");
					}while(true);
					for(int i=0;i<playgroundlist.size();i++) {
						if(p==(i+1)) {
							playgroundlist.get(i).getFreeslot();
							System.out.println("Enter free slot: ");
							do {
								k=myscanner.nextInt();
								if(k>0&&k<playgroundlist.get(i).freeslotsize()+1) {
									if(playgroundlist.get(i).checking(k-1)==true)
										{System.out.println("This freeslot is booked !");
										break;
										}
									else {
									bookings _booking =new bookings();
									_booking.setFree(playgroundlist.get(i).getFreeslotlist().get(k-1).getfreeslot());
									_booking.set_playground(playgroundlist.get(i));
									_booking.set_playground(playgroundlist.get(i));
									playerlist.get(y).getBooking().add(_booking);
									playgroundlist.get(i).bookfree(k-1);;
									playgroundlist.get(i).setplayer(k-1,playerlist.get(y));
									playerlist.get(y).setBook(true);
									playerlist.get(y).getWallet().paymoney(playgroundlist.get(i).getPrice());
									playgroundlist.get(i).get_owner().getWallet().collectmoney(playgroundlist.get(i).getPrice());
									System.out.println("The free slot is booked succesfully!");
									break;}
								    }
								else
									System.out.println("You entered invalid input please enter valid input: ");
							}while(true);	
						}
						else
							continue;
					}}
					System.out.println("Press b if you want to go back: ");
					do {
						back=myscanner.next();
						if(back.equals("b")||back.equals("B"))
							break;
						else
							System.out.println("You entered invalid input!  please enter valid input: ");
					}while(true);
					break;
				case 2:
						for(int r=playerlist.get(y).teamnum();r<5;r++) {
							System.out.println("Enter your friend e-mail: ");
					do {
						back="0";
				     searching=0;
					 email=myscanner.next();
					for(int i=0;i<userlist.size();i++) {
						if(userlist.get(i).getEmail().equals(email)&&userlist.get(i).isType()==true&&playerlist.get(y).getEmail().equals(email)!=true&&playerlist.get(y).searching(email)==false) { 
							searching++;
							for(int h=0;h<playerlist.size();h++) {
								if(playerlist.get(h).getEmail().equals(email)) {
								u=h;
								break;
								}
								else
									continue;
							}
							break;
							}
						else
							continue;
					}
					if(searching==0)
						{System.out.println("E-mail is not valid! press a to enter another email or press b if you want to go back to the menu: ");
						do {
							back=myscanner.next();
							if(back.equals("b")||back.equals("B")||back.equals("a")||back.equals("A"))
								break;
							else
								System.out.println("You entered invalid input!  please enter valid input: ");
						}while(true);
					if(back.equals("b")||back.equals("b"))
						break;
						else
							continue;
						}
					else
						break;
					}while(true);
					if(back.equals("b")||back.equals("b"))
						break;
					System.out.println("Invitation is sent");
					playerlist.get(y).addplayer(playerlist.get(u));
					back="0";
					System.out.println("Press b if you want to go back to menu or a to add another player to the team: ");
					do {
						back=myscanner.next();
						if(back.equals("b")||back.equals("B")||back.equals("a")||back.equals("A"))
							break;
						else
							System.out.println("You entered invalid input!  please enter valid input: ");
					}while(true);
					if(back.equals("b")||back.equals("B"))
						break;
					}
					break;
				case 3:
					do {
					if(playerlist.get(y).bookingsize()==0)
						{System.out.println("\t\t Bookings \n\n There are no bookings!");
						 System.out.println("Press b if you want to go back: ");
						do {
							back=myscanner.next();
							if(back.equals("b")||back.equals("B"))
								break;
							else
								System.out.println("You entered invalid input!  please enter valid input: ");
						  }while(true);
						break;
						}
					else{
						System.out.println("\t \t bookings\n\n");
						playerlist.get(y).getbooking();
						System.out.println("Press b if you want to go back and c if you want to cancel booking: ");
						do {
							back=myscanner.next();
							if(back.equals("b")||back.equals("B")||back.equals("c")||back.equals("C"))
								break;
							else
								System.out.println("You entered invalid input please enter valid input: ");
						  }while(true);
						if(back.equals("c")||back.equals("C")) {
							System.out.println("Enter the choice you want to cancel: ");
							do {
							p=myscanner.nextInt();
							if(p>0&&p<playerlist.get(y).bookingsize()+1)
								break;
							else
								System.out.println("You entered invalid input please enter valid input: ");
							}while(true);
							for(int i=0;i<playgroundlist.size();i++) {
								if(playerlist.get(y).getBooking().get(p-1).get_playground()==playgroundlist.get(i))
									{playgroundlist.get(i).searching(playerlist.get(y).getBooking().get(p-1).getFree());
									playerlist.get(y).getBooking().remove(p-1);
									playerlist.get(y).getWallet().collectmoney(playgroundlist.get(i).getPrice());
									playgroundlist.get(i).get_owner().getWallet().paymoney(playgroundlist.get(i).getPrice());
									System.out.println("The booking is canceled! \n\n");
									break;
									}
								else
									continue;
									}
							}
						else
							break;
					}
						}while(true);
					break;
				case 4:
					do {
				    System.out.println("\t\t Favourite Team \n\n");
					playerlist.get(y).getplayer();
					System.out.println("Press b if you want to go back  or m if you want to modify your favourite team: ");
					do {
						back=myscanner.next();
						if(back.equals("b")||back.equals("B")||back.equals("m")||back.equals("M"))
							break;
						else
							System.out.println("You entered invalid input!  please enter valid input: ");
					}while(true);
					if(back.equals("m")||back.equals("M"))
					{
						System.out.println("1-add player \n2-remove player");
						p=myscanner.nextInt();
						switch(p) {
						case 1:
							if(playerlist.get(y).teamnum()==5)
								System.out.println("The team is full");
							else {
								System.out.println("Enter your friend E-mail: ");
								do {
								     searching=0;
									 email=myscanner.next();
									for(int i=0;i<userlist.size();i++) {
										if(userlist.get(i).getEmail().equals(email)&&userlist.get(i).isType()==true&&playerlist.get(y).getEmail().equals(email)!=true&&playerlist.get(y).searching(email)==false) { 
											searching++;
											for(int h=0;h<playerlist.size();h++) {
												if(playerlist.get(h).getEmail().equals(email)) {
												u=h;
												break;
												}
												else
													continue;
											}
											break;
											}
									   else
											continue;
									}
									if(searching==0)
									{System.out.println("E-mail is not found! press a to enter another email or press b if you want to go back: ");
									do {
										back=myscanner.next();
										if(back.equals("b")||back.equals("B")||back.equals("a")||back.equals("A"))
											break;
										else
											System.out.println("You entered invalid input!  please enter valid input: ");
									}while(true);
								  if(back.equals("b")||back.equals("b"))
									break;
									}
								else
									break;
								}while(true);
								if(searching!=0)
								{
									System.out.println("Invitation is sent");
									playerlist.get(y).addplayer(playerlist.get(u));
								}
								}
						       break;
						case 2:
							playerlist.get(y).getplayer();
							System.out.println("Enter player you want to remove:");
							do {
								p=myscanner.nextInt();
								if(p>0&&p<playerlist.get(y).teamnum()+1)
								{
									playerlist.get(y).removeplayer(p-1);
									break;
								}
								else
									System.out.println("You entered invalid input please enter valid input: ");
							}while(true);
							break;
						default:
							System.out.println("You entered invalid input please enter valid input: ");
							}
							}
					else
						break;
						}while(true);
					break;
				case 5:
					System.out.println("\t\t eWallet \n\n Your balance is "+playerlist.get(y).getWallet().getBalance());
					System.out.println("Press b if you want to go back: ");
					do {
						back=myscanner.next();
						if(back.equals("b")||back.equals("B"))
							break;
						else
							System.out.println("You entered invalid input!  please enter valid input: ");
					}while(true);
					break;
				case 6:
					System.out.println("\t\t Profile \n\n Name: "+playerlist.get(y).getName()+"\n");
					System.out.println("E-mail: "+playerlist.get(y).getEmail()+"\n");
					System.out.println("Phone: "+playerlist.get(y).getPhone()+"\n");
					System.out.println("Location: "+playerlist.get(y).getLocation()+"\n");
					System.out.println("Press b if you want to go back: ");
					do {
						back=myscanner.next();
						if(back.equals("b")||back.equals("B"))
							break;
						else
							System.out.println("You entered invalid input!  please enter valid input: ");
					}while(true);
					break;
				case 7:
					break;
				default:
					System.out.println("You entered invalid input please enter valid input: ");
					}
				 }while(p!=7);

				}
			else {
				do {
				System.out.println("1-Adding playground"+"\n2-check bookings "+"\n3-check my playground"+"\n4-check money in eWallet"+"\n5-view profile"+"\n6-logout");
				k=myscanner.nextInt();
				switch(k) {
				case 1:
					playground _playground=new playground();
					System.out.println("Enter playground name: ");
					name=myscanner.nextLine();
					name=myscanner.nextLine();
					_playground.setName(name);
					System.out.println("Enter playground location: ");
					location=myscanner.nextLine();
					_playground.setLocation(location);
					System.out.println("Enter the price per hour: ");
					price=myscanner.nextInt();
					_playground.setPrice(price);
					System.out.println("Enter playground size: ");
					size=myscanner.nextDouble();
					_playground.setSize(size);
					_playground.setOwner(ownerlist.get(y).getName());
					_playground.set_owner(ownerlist.get(y));
					ArrayList<freeslots> freeslotlist=new ArrayList<freeslots>();
					System.out.println("Enter the numbers of freeslots: ");
					do {
						k=myscanner.nextInt();
						if(k>0&&k<=24)
							break;
						else
							System.out.println("You entered invalid input enter valid input: \t (the number of freeslot must be less than or equal 24)");
					}while(true);
					for(int i=0;i<k;i++) {
						freeslots freeslot=new freeslots();
						System.out.println("Enter freeslot "+(i+1)+": \t\t"+"(freeslot must be in format 00:00)");
						do {
							free=myscanner.next();
							if(free.contains(":"))
								break;
							else
								System.out.println("this is invalid input please enter valid input: ");
						}while(true);
						freeslot.set_freeslot(free);
						freeslot.set_playground(_playground);
						freeslotlist.add(freeslot);
					}
			        _playground.setFreeslotlist(freeslotlist);
					System.out.println("Playground Added!");
					playgroundlist.add(_playground);
					System.out.println("Press b if you want to go back: ");
					do {
						back=myscanner.next();
						if(back.equals("b")||back.equals("B"))
							break;
						else
							System.out.println("You entered invalid input!  please enter valid input: ");
					}while(true);
					break;
				case 2:
					System.out.println("\t\t Bookings\n");
					for(int i=0;i<playgroundlist.size();i++) {
						if(playgroundlist.get(i).get_owner()==ownerlist.get(y)) {
							System.out.println("Playground: "+playgroundlist.get(i).getName()+"\n");
							playgroundlist.get(i).viewbooked();
							System.out.println("\n \n");
						}
						else
							continue;
					}
					System.out.println("Press b if you want to go back: ");
					do {
						back=myscanner.next();
						if(back.equals("b")||back.equals("B"))
							break;
						else
							System.out.println("You entered invalid input!  please enter valid input: ");
					}while(true);
					break;
				case 3:
					do {
					searching=0;
					int q=0;
					System.out.println("\t\t Playgrounds\n\n");
					for(int i=0;i<playgroundlist.size();i++) {
						if(playgroundlist.get(i).get_owner()==ownerlist.get(y)) {
							q++;
							System.out.println(q+"- ");
							System.out.println(playgroundlist.get(i).display()+"\n\n");
							searching++;
						}
						else
							continue;
					}
					if(searching==0)
						{System.out.println("There are no playgrounds");
						System.out.println("Press b if you want to go back: ");
						do {
							back=myscanner.next();
							if(back.equals("b")||back.equals("B"))
								break;
							else
								System.out.println("You entered invalid input!  please enter valid input: ");
						}while(true);
						break;
						}
					else {
						System.out.println("press b if you want to go back or r to remove playground: ");
						do {
							back=myscanner.next();
							if(back.equals("b")||back.equals("B")||back.equals("r")||back.equals("R"))
								break;
							else
								System.out.println("You entered invalid input!  please enter valid input: ");
						}while(true);
						if(back.equals("r")||back.equals("R")) {
						  System.out.println("Enter the playground you want to remove:");
						do {
							q=0;
							p=myscanner.nextInt();
							if(p>0&&p<=searching) {
								for(int i=0;i<playgroundlist.size();i++) {
									if(playgroundlist.get(i).get_owner()==ownerlist.get(y)) {
										q++;
										if(p==q)
											{playgroundlist.remove(i);
											System.out.println("Playground is removed");
											break;
											}
										else
											continue;
									}
								}
								break;
							}
							else
								System.out.println("You entered invalid input please enter valid input: ");
						}while(true);
					}
						else
							break;
					}
					}while(true);
					break;
				case 4:
					System.out.println("\t\t eWallet \n\n Your balance is "+ownerlist.get(y).getWallet().getBalance());
					System.out.println("Press b if you want to go back: ");
					do {
						back=myscanner.next();
						if(back.equals("b")||back.equals("B"))
							break;
						else
							System.out.println("You entered invalid input!  please enter valid input: ");
					}while(true);
					break;
				case 5:
					System.out.println("\t\t Profile \n\n Name: "+ownerlist.get(y).getName()+"\n");
					System.out.println("E-mail: "+ownerlist.get(y).getEmail()+"\n");
					System.out.println("Phone: "+ownerlist.get(y).getPhone()+"\n");
					System.out.println("Location: "+ownerlist.get(y).getLocation()+"\n");
					System.out.println("Press b if you want to go back: ");
					do {
						back=myscanner.next();
						if(back.equals("b")||back.equals("B"))
							break;
						else
							System.out.println("You entered invalid input!  please enter valid input: ");
					}while(true);
					break;
				case 6:
					break;
				default:
					System.out.println("You entered invalid input please enter valid input: ");	
				}
				}while(k!=6);
			}
			}
			}while(true);
		}
		}

	



