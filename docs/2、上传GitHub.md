# 将本地项目上传到GitHub上

## 注册GitHub账号
   如果你还没有 GitHub 账号，需要在 GitHub 官方网站（https://github.com/）注册一个账号。注册过程中需要提供一些基本信息，如用户名、邮箱地址和密码等。
   
## 在GitHub上创建远程仓库
   登录到 GitHub 账号，点击页面右上角的 “+” 号，然后选择 “New repository”（新建仓库）。在创建仓库页面，你需要填写仓库的名称、描述（可选）等信息。如果你的本地项目是一个私有项目，不想被其他人看到，可以将仓库的可见性设置为 “Private”（私有）；如果想分享给他人，可以设置为 “Public”（公有）。填写完成后，点击 “Create repository”（创建仓库）按钮。
   
## 推送本地项目到GitHub
   可以用以下指令推送到GitHub，这些指令在仓库创建后就能看到。
    
    echo "# test" >> README.md
    git init
    git add README.md
    git commit -m "first commit"
    git branch -M main
    git remote add origin https://github.com/SpringBoot-Guru/test.git
    git push -u origin main
    
* 需要注意的是：从2021年8月份开始，GitHub中通过用户名+密码的认证方式被移除了，只能通过个人访问码的方式进行认证，也就是用户名+个人访问码。

## 个人访问码如何获取
1、进入设置页面：点击右上角的头像，然后选择 “Settings”（设置）
2、打开开发者设置：在左侧导航栏中，选择 “Developer settings”（开发者设置）。
3、在下拉菜单中，点击 “Personal access tokens”（个人访问令牌）下面的“Tokens（classic）。
4、生成新的访问令牌：点击 “Generate new token” 按钮来创建一个新的访问令牌，之后根据提示进行操作。如果只是个人练习，全部勾选即可。
5、完成创建：完成上述设置后，点击页面底部的 “Generate token” 按钮，GitHub 将生成一个个人访问令牌，务必及时复制并妥善保管该令牌，因为页面刷新后将无法再次查看此令牌的完整内容。

