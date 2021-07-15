import tkinter as tk	#imports tkinter as tk
from tkinter import * 	#imports everything from the tk library

master = Tk()	#declares an instance of the Tk class
canvas_width = 800	#sets canvas width to 800 pixels
canvas_height =800	#sets canvs height to 800 pixels
w = Canvas(master, width = canvas_width, height = canvas_height)#declares w to be an instance of Canvas
w.pack()#fills the screen with 


def main():#defines main function
    initial()#calls the initial function to set the sceen to a face
    b = Button(master, text="EYES", command=eyes)#has a button to call a command to change the eyes
    b.pack()#fills the canvas with the modified look

    b1 = Button(master, text="Mouth", command=mouth)#calls command to change mouth
    b1.pack()#fills the canvas with the modified look

    b3 = Button(master, text='RESET', command=initial)#button to reset the screen
    b3.pack()#fills the canvas with the original look

    b4 = Button(master, text='QUIT', command=quit)#button to exit the program
    b4.pack()#exits the program
    

def eyes():#defines function to change eyes
    w.delete("all")#clears screen
    w.create_rectangle(0,0, canvas_width, canvas_height, fill="green")#draws a rectangle to fill screen with the color green 
    w.create_oval(50, 50, canvas_width-50, canvas_height-50, width=5)#draws oval for head

    w.create_oval(270, 200, 350, 275, width=3, fill='black')#draws oval for eyes with a black fill
    w.create_oval(530, 200, 450, 275, width=3, fill='black')
    
    w.create_oval(200, 525, 600, 575, width=3)#draws mouth

    
    
def initial():#defines initial state
    w.delete("all")#clears screen
    w.create_rectangle(0,0, canvas_width, canvas_height, fill="green")#draws rectangle to fill screen with green
    w.create_oval(50, 50, canvas_width-50, canvas_height-50, width=5)#draws oval for head

    w.create_oval(270, 200, 350, 275, width=3)#draws ovals for eyes
    w.create_oval(530, 200, 450, 275, width=3)
    
    w.create_oval(200, 525, 600, 575, width=3)#draws oval for mouth
    
def mouth():#function to change mouth
    w.delete("all")#clears screen
    w.create_rectangle(0,0, canvas_width, canvas_height, fill="green")#draws rectangle to fill screen with green
    w.create_oval(50, 50, canvas_width-50, canvas_height-50, width=5)#draaws oval for head

    w.create_oval(270, 200, 350, 275, width=3)#draws ovals for eyes
    w.create_oval(530, 200, 450, 275, width=3)
    
    w.create_oval(200, 400, 600, 700, width=3, fill='red')  #draws oval for mouth that is filled with red
      
               

main()#calls the main function
