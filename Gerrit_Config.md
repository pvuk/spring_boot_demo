## [How to install Gerrit on Windows](https://github.com/Sl0v3C/Install_Gerrit_4Windows_Guide)

* [How to install Gerrit on Windows](https://github.com/Sl0v3C/Install_Gerrit_4Windows_Guide)
* [Account - Login](https://gerrit.wikimedia.org/r/#/dashboard/self)

* [Gerrit - Installation](https://www.tutorialspoint.com/gerrit/gerrit_add_ssh_key_to_gerrit_account.htm)

#### Add SSH Public Key
> How to Generate an SSH Key
 
* From the Terminal or Git Bash, run ssh-keygen
* Confirm the default path .ssh/id_rsa
* Enter a passphrase (recommended) or leave it blank.
Remember this passphrase, as you will need it to unlock the
key whenever you use it.
* Open ~/.ssh/id_rsa.pub and copy & paste the contents into
the box below, then click on "Add".
Note that id_rsa.pub is your public key and can be shared,
while id_rsa is your private key and should be kept secret.

> You can add SSH key to Git using the following commands −

* Step 1 − Open Git Bash and get the ssh-agent using the following command.

>go to C:\$Installation_Folder$\Git\cmd and execute:

`start-ssh-agent`

<!-- [`eval $(ssh-agent)`](https://stackoverflow.com/a/21909432/1624035) -->

* Step 2 − Next, add the SSH key to the ssh-agent using the following command

`$ ssh-add ~/.ssh/id_rsa`

>[Start OpenSSH Authentication Agent in services.msc](https://i.stack.imgur.com/KwDuu.png)

* Step 3 − Now, run the ssh using the following command, which matches the SSH fingerprint used when logging for the first time.

`$ ssh -p 29418 pvuk@gerrit.wikimedia.org`