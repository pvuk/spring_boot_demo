#### [How to show your Git username](https://alvinalexander.com/git/git-show-change-username-email-address)
>Here’s the git config command:

`git config user.name`

>Another way to show your Git username is with this git config command:

`git config --list`

>How to change your Git username

`git config --global user.name "P V UdayKiran"`

> Again, it’s important to note that this is your “global” username. You can also have a different username on a per-project basis ... I just looked it up, and you should be able to change your Git username on a per-project basis like this, without the --global option:

`git config user.name "P V UdayKiran"`

#### How to change your Git email address
While I’m in the Git username neighborhood, I’ll also add that you can view your Git email address with this command:

`git config user.email`

And you can change your Git email address like this:

`git config --global user.email [your email address here]`