<!--- STARTEXCLUDE --->
# Workshop Apache Beam and Google DataFlow

[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/datastaxdevs/workshop-beam)
[![License Apache2](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Discord](https://img.shields.io/discord/685554030159593522)](https://discord.com/widget?id=685554030159593522&theme=dark)


## 📋 Table of content

[**HOUSEKEEPING**](#)
- [Objectives](#objectives)
- [Frequently asked questions](#frequently-asked-questions)
- [Materials for the Session](#materials-for-the-session)

[**LAB**](#1-database-initialization)
- [01. Create Astra Account](#-1---create-your-datastax-astra-account)
- [02. Create Astra Token](#-2---create-an-astra-token)
- [03. Copy the token](#-3---copy-the-token-value-in-your-clipboard)
- [04. Open Gitpod](#)
- [05. Setup CLI](#)
- [06. Create Database](#)
- [07. Setup env variables](#)



---- 

## HouseKeeping

### Objectives

* Introduce AstraDB and Vector Search capability
* Give you an first understanding about Apache Beam and Google DataFlow
* Discover NoSQL dsitributed databases and specially Apache Cassandra™.
* Getting familiar with a few Google Cloud Platform services

### Frequently asked questions

<p/>
<details>
<summary><b> 1️⃣ Can I run this workshop on my computer?</b></summary>
<hr>
<p>There is nothing preventing you from running the workshop on your own machine, If you do so, you will need the following
<ol>
<li><b>git</b> installed on your local system
<li><b>Java</b> installed on your local system
<li><b>Maven</b> installed on your local system
</ol>
</p>
In this readme, we try to provide instructions for local development as well - but keep in mind that the main focus is development on Gitpod, hence <strong>We can't guarantee live support</strong> about local development in order to keep on track with the schedule. However, we will do our best to give you the info you need to succeed.
</details>
<p/>
<details>
<summary><b> 2️⃣ What other prerequisites are required?</b></summary>
<hr>
<ul>
<li>You will need an enough *real estate* on screen, we will ask you to open a few windows and it does not file mobiles (tablets should be OK)
<li>You will need a GitHub account eventually a google account for the Google Authentication (optional)
<li>You will need an Astra account: don't worry, we'll work through that in the following
<li>As Intermediate level we expect you to know what java and maven are
</ul>
</p>
</details>
<p/>
<details>
<summary><b> 3️⃣ Do I need to pay for anything for this workshop?</b></summary>
<hr>
<b>No.</b> All tools and services we provide here are FREE. FREE not only during the session but also after.
</details>
<p/>
<details>
<summary><b> 4️⃣ Will I get a certificate if I attend this workshop?</b></summary>
<hr>
Attending the session is not enough. You need to complete the homeworks detailed below and you will get a nice badge that you can share on linkedin or anywhere else *(open api badge)*
</details>
<p/>

> [🏠 Back to Table of Contents](#-table-of-content)

### Materials for the Session

It doesn't matter if you join our workshop live or you prefer to work at your own pace,
we have you covered. In this repository, you'll find everything you need for this workshop:

- [Slide deck](/slides/slides.pdf)
- [Discord chat](https://dtsx.io/discord)

----

## LAB

#### ✅ `1` - Create your DataStax Astra account

> ℹ️ Account creation tutorial is available in [awesome astra](https://awesome-astra.github.io/docs/pages/astra/create-account/)


_click the image below or go to [https://astra.datastax./com](https://astra.datastax./com)_

<a href="https://astra.dev/3B7HcYo">
<img src="https://awesome-astra.github.io/docs/img/astra/astra-signin-github-0.png" />
</a>
<br/>


#### ✅ `2` - Create an Astra Token

> ℹ️ Token creation tutorial is available in [awesome astra](https://awesome-astra.github.io/docs/pages/astra/create-token/#c-procedure)

- `Locate `Settings` (#1) in the menu on the left, then `Token Management` (#2) 

- Select the role `Organization Administrator` before clicking `[Generate Token]`

![](https://github.com/DataStax-Academy/cassandra-for-data-engineers/blob/main/images/setup-astra-2.png?raw=true)

The Token is in fact three separate strings: a `Client ID`, a `Client Secret` and the `token` proper. You will need some of these strings to access the database, depending on the type of access you plan. Although the Client ID, strictly speaking, is not a secret, you should regard this whole object as a secret and make sure not to share it inadvertently (e.g. committing it to a Git repository) as it grants access to your databases.

```json
{
  "ClientId": "ROkiiDZdvPOvHRSgoZtyAapp",
  "ClientSecret": "fakedfaked",
  "Token":"AstraCS:fake"
}
```

#### ✅ `3` - Copy the token value in your clipboard

You can also leave the windo open to copy the value in a second.

#### ✅ `4` - Open Gitpod

> 
> ↗️ _Right Click and select open as a new Tab..._
>
> [![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/datastaxdevs/workshop-beam)
> 


![](./img/gitpod.png)


#### ✅ `5` - Set up the CLI with your token

_In gitpod, in a terminal window:_

- Login

```bash
astra login --token AstraCS:fake
```

- Validate your are setup

```bash
astra org
```

> **Output**
> ```
> gitpod /workspace/workshop-beam (main) $ astra org
> +----------------+-----------------------------------------+
> | Attribute      | Value                                   |
> +----------------+-----------------------------------------+
> | Name           | cedrick.lunven@datastax.com             |
> | id             | f9460f14-9879-4ebe-83f2-48d3f3dce13c    |
> +----------------+-----------------------------------------+
> ```


#### ✅ `6` - Create a Database `demo` and a keyspace `samples_beam`

> ℹ️ You can notice we enabled the Vector Search capability 

- Create db `workshop_beam` and wait for the DB to become active

```
astra db create workshop_beam -k beam --vector --if-not-exists
```

> 💻 Output
> 
> ![](./img/astra-db-create.png)

- List databases

```
astra db list
```

> 💻 Output
> 
> ![](./img/astra-db-list.png)

- Describe your db

```
astra db describe workshop_beam
```

> 💻 Output
> 
> ![](./img/astra-db-describe.png)


#### ✅ `7` - Setup env variables

- Create file with var

```bash
astra db create-dotenv workshop_beam 
```

- Show the file

```
cat .env
```


- Load env variables
```
set -a
source .env
set +a

env | grep ASTRA
```
