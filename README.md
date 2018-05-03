# github-issues-exporter

This program exports all issues and pull requests data of a specified project on GitHub as a ndjson file.

First, create `~/.github` which supplies authentication information as follows:

```
login=username
password=0123456789
```

or

```
oauth=4d98173f7c075527cb64878561d1fe70
```

Then run the program with a argument to specify the target project:

```
$ sbt run "Main owner/repository"
```

All all issues and pull requests data will be exported to `export.json`.
