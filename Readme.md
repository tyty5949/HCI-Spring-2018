# Human Computer Interaction - Spring 2018
David Jones, Shobey Stanley, Jason Long, Richard Yang, and Tyler Hunt

## Git Instructions
#### Cloning Repository
Cloning a repository is just git speak for downloading the project from the server. It also initializes all of the backend stuff that git needs to function. You MUST do this, not simply just create your own folder on your computer, otherwise how would git know that it should be linked to this project?
1. If you don't already have git install it from here [https://git-scm.com/](https://git-scm.com/ "https://git-scm.com/")
2. Navigate to the directory which you want to download the project to.

	**NOTE:** *Will create a directory for you called "HCI-Spring-2018"*
3. >git clone https://github.com/tyty5949/HCI-Spring-2018.git

#### Creating Your Own Branch
We will used branches to commit our individual work to so that when the time comes, it is relatively easy to implement someones design into our master branch (group product). You can think of a branch as still part of the project, but any changes you make to your branch will not affect any other branches until we explicity tell git to do so.
1. Using the git CMD navigate into the project directory.
	>cd HCI-Spring-2018
2. To create the branch, use the following command replacing my name with your own first name in all lowercase.
	>git branch tyler
3. To switch to your newly created branch use the following command again replacing my name with the name of the branch you just created.
	>git checkout tyler
4. Now to inform the server that a new branch has been created use the following command again replacing my name with the name of your branch.
	>git push origin tyler

#### Saving Your Work To Your Branch
Git is useful because it creates a standardized way to share work between other members of a project. You do this by either saving your work to your branch, or downloading someone elses from their own. Not only does it allow for sharing but it also acts as a cloud backup for your work so I would commit and push often.
1. Make sure your git cmd is set to your git project.
2. The next step is to inform git which files you wish to save. To view the files you have changed use the command
	>git status
    
	This will list all of the files have been changed of created but are not listed to be saved in red and files that are going to be updated by this commit in green. To tell git to save a file use the command replacing myfile.txt with either the file of directory which you want to be included in this commit.
	>git add myfile.txt
    
	You could again issue the git status command again to make sure that your choosen file turns green.
	
	**IMPORTANT:** *You should only choose to save source files, data files, or art resources to the server. There is no reason to include your .eclipse folder or .project file as everyone elses will be different. You branch will include a file which will automatically attempt to stop you from doing this by ignoring certain files but try to only add the absolute essential files that others would need to run your project.*

3. To actually save your files use the following command but replacing message with a brief description of what you have accomplished since your last commit.
	>git commit -m "message"
4. Now, all you have done is staged your changes, almost like creating a restore point, but you have not yet informed the server about this. Issue the following command but replacing tyler with the name of your own branch.
	>git push origin tyler

#### Updating Your Branch From The Server
If you are only using one computer ignore this. However, if you will switch between using other computers such as laptop, desktop, lab computers, etc. when you commit and push your work on one computer the others will not know that any changes have taken place nor will they download the changes.
1. On the computer that is out-of-date make sure your git cmd is set to your git project.
2. Also make sure you have your branch that you want to get the changes from checked out and active.
3. To bring the changes from the server down to your computer issue the following command replacing my name with the name of your branch.
	>git pull origin tyler
    
	**NOTE:** *This will overwrite any changes that have been made on your local computer, local working copy, with the changes on the server.*

#### Viewing Other Peoples Branches
So when everyone has completed their parts and we want to try out others to decide whos we want to implement, we use the following steps. 

**Note:** *Since we are not tracking project metadata, commiting our .project and .eclipse folders, when we issue these command your IDE may not appreciate its metadata being removed. I have not tested it, but just to be careful I would close your IDE, issue these commands, then re-open the project.*
1. Make sure your git cmd is set to your git project. 

	**Important:** *You must have commited your changes before doing this otherwise they will be overwritten!*
2. We need to inform git on our computer that changes have taken place on the server. We must always issue the following commands any time we need to view other branches.
	>git fetch origin
3. Next we then checkout the branch we want to view replacing david with the name of any branch.
	>git checkout origin/david
    
	**NOTE:** *Never commit and push on someones branch without their permission!*

#### Replacing Your Branch With The Master Branch
After every group project checkpoint we will be selecting someones design to implement as our group decision. When this is done their branch will be merged into the master branch. When this happens all of our individual branches are not out-of-date meaning that changes have been made to the master but they will not be reflected in our branches.
1. Make sure your git cmd is set to your git project.
2. In order to tell the project on your computer, your working copy, that changes have been made to the master issue the following command.
	>git fetch origin
3. Now to actually replace your branch with the master, issue the command.
	>git reset --hard master
    
	**NOTE:** *This will replace all of your work with the master branch. You can still view your individual work on github by browsing past commits or you can even checkout past commits. Google around for more information on this.*
4. Now that you have made changes to your branch on your computer, we now have to tell the server, again, replace my name with the name of your branch.
	>git push origin tyler

## Git Resources
A well-made, basic, interactive tutorial.
[https://try.github.io/levels/1/challenges/1](https://try.github.io/levels/1/challenges/1 "https://try.github.io/levels/1/challenges/1")

More in-depth look at branch workflows. Instead of a singular develop branch, we will each essentially have our own develop branches.
[http://nvie.com/posts/a-successful-git-branching-model/](http://nvie.com/posts/a-successful-git-branching-model/ "http://nvie.com/posts/a-successful-git-branching-model/")

My preferred GUI (or just command line)
[https://www.sourcetreeapp.com/](https://www.sourcetreeapp.com/ "https://www.sourcetreeapp.com/")

List of most used commands.
[https://confluence.atlassian.com/bitbucketserver/basic-git-commands-776639767.html](https://confluence.atlassian.com/bitbucketserver/basic-git-commands-776639767.html "https://confluence.atlassian.com/bitbucketserver/basic-git-commands-776639767.html")