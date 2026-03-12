# MITM Attack and Defence Simulator

<img src="https://i.pinimg.com/originals/c4/15/be/c415be334309ccf0b19a2c0a44c73331.gif"></img>

## Overview

I haven't settled on a formal name for this project yet, but the goal was to explore network security and data interception. Originally, I wanted to build a system that could intercept an encrypted file mid-transmission without either party noticing.

After researching the complexities and ethical implications of such a tool, I decided to pivot. Instead of a "live" attack system, I developed this Simulation Project. It uses Java to implement a simplified version of the Man-in-the-Middle (MITM) theory to demonstrate how data can be intercepted and how encryption serves as a defense.

## Features
- **MITM**: A practical application of Man-in-the-Middle theory.
- **Java Based**: Utilizes Java libraries for robust execution.
- **AES Encryption**: Implements Advanced Encryption Standard (AES) for data security.
- **LAN Based**: Designed to work between devices connected to the same Local Area Network.

## How to Use
1. **Sender**: Open the Sender program and write a message in the designated text file.
2. **Attacker**: Run the Attack program on the same system as the sender to begin interception.
3. **Receiver**: On a second machine, run the Receiver program to accept the data.
4. **Encryption Keys**: Ensure both systems have the required crypto files to handle the encryption and decryption processes.

## Technology Used
- **Java**: Core programming language.
- **Java Crypto Libraries**: For implementing AES encryption and decryption.
- 
## Contribution
If you'd like to contribute, feel free to fork the repository and suggest improvements via **issues** or **pull requests**.

## Contact
For any questions or feedback, feel free to reach out:

- **Email**: aliakbarkhana79@gmail.com
- **LinkedIn**: [aliiakbarkhan](https://www.linkedin.com/in/aliiakbarkhan)

---
