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

#### How to remove entry in global configuration
>You can use the --unset flag of git config to do this like so:

`git config --global --unset user.name`
`git config --global --unset user.email`
>If you have more variables for one config you can use:

`git config --global --unset-all user.name`

###	[A new repo from an existing project](https://kbroman.org/github_tutorial/pages/init.html)
Say you’ve got an existing project that you want to start tracking with git.

Go into the directory containing the project.
* Type `git init`.
* Type `git add .` to add all of the relevant files.

> `git commit -m 'Initial commit'`

*** Please tell me who you are.

Run

  git config --global user.email "you@example.com"
  git config --global user.name "Your Name"
> If you get above errors run below commands
 * `$ git config --global user.name "P V UdayKiran"`
 * `$ git config --global user.email "youremail@domain.com"`

####Connect it to github
You’ve now got a local git repository. You can use git locally, like that, if you want. But if you want the thing to have a home on github, do the following.
* Go to github.
* Log in to your account.
* Click the new repository button in the top-right. You’ll have an option there to initialize the repository with a README file, but I don’t.
* Click the “Create repository” button.

> Now, follow the second set of instructions, “Push an existing repository…”

`$ git remote add origin git@github.com:pvuk/spring_practice.git`
> Following is SSH path of repository git@github.com:gitpvuk/spring_practice.git

[Note that git add](https://kbroman.org/github_tutorial/pages/routine.html) is used to add completely new files as well as to “add” modifications to files that already exist in the repository.

The commit message should be short (40 or 60 characters) so it’s easy to read in a list. For a more complex commit, write an initial line that is short and gives the overall idea, followed by as many lines as you want giving the details.

People tend to write commit messages in the present rather than past tense (eg, “Fix such and such” rather than “Fixed such and such”).

For a one-line commit message, you can skip the text editor business and just type

`$ git commit -m "Fix such and such"`

`$ git push --set-upstream origin master`

[Check that you are connecting to the correct server](https://help.github.com/en/github/authenticating-to-github/error-permission-denied-publickey#check-that-you-are-connecting-to-the-correct-server)

Typing is hard, we all know it. Pay attention to what you type; you won't be able to connect to "githib.com" or "guthub.com". In some cases, a corporate network may cause issues resolving the DNS record as well.

To make sure you are connecting to the right domain, you can enter the following command:

`$ ssh -vT git@github.com`