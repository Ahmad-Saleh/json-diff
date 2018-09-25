## JSON Diff

Write a program that will calculate the difference between two JSON documents.

You should implement the `JsonDiff` interface, that has a single method `compare()` that accepts two arguments; the 
`original` JSON and the `updated` JSON. The implementation method should return a JSON String that contain only the 
differences between them.

Examples:


Example 1
---
**original** JSON:
```json
{
  "name": "Abbas",
  "dateOfBirth": "1990-01-01"
}
```

**updated** JSON:
```json
{
  "name": "Khalaf",
  "dateOfBirth": "1990-01-01"
}
```

**diff** JSON should be:
```json
{
  "name": "Khalaf"
}
```

Example 2
---
Note that not all properties has to be present in the **updated** JSON

**original** JSON:
```json
{
  "name": "Abbas",
  "dateOfBirth": "1990-01-01",
  "title": "Developer"
}
```

**updated** JSON:
```json
{
  "name": "Abbas",
  "title": "Senior Developer"
}
```

**diff** JSON should be:
```json
{
  "title": "Senior Developer"
}
```

Example 3
---
Note that if a property is set to null in the **updated** JSON, it should appear in the **diff** JSON

**original** JSON:
```json
{
  "name": "Abbas",
  "dateOfBirth": "1990-01-01",
  "title": "Developer"
}
```

**updated** JSON:
```json
{
  "name": "Abbas",
  "title": "Senior Developer",
  "dateOfBirth": null
}
```

**diff** JSON should be:
```json
{
  "title": "Senior Developer",
  "dateOfBirth": null
}
```

Example 4
---
Note that new properties in the **updated** JSON should be considered as diff even if they do not appear in the **original**
and that the order of the properties doesn't matter

**original** JSON:
```json
{
  "name": "Abbas",
  "dateOfBirth": "1990-01-01",
  "title": "Developer"
}
```

**updated** JSON:
```json
{
  "dateOfBirth": "1990-01-01",
  "title": "Senior Developer",
  "manager": {
    "name": "Jaber"
  },
  "name": "Abbas"
}
```

**diff** JSON should be:
```json
{
  "title": "Senior Developer",
  "dateOfBirth": null,
  "manager": {
    "name": "Jaber"
  }
}
```

Example 5
---
Note that the comparison should work for nested properties and arrays

**original** JSON:
```json
{
  "name": "Abbas",
  "dateOfBirth": "1990-01-01",
  "title": "Developer",
  "manager":{
    "name": "Jaber",
    "title": "Development Manager"
  },
  "department": {
    "departmentName": "Development",
    "relatedDepartment": [
      {
        "departmentName": "Marketing"
      },
      {
        "departmentName": "Human Capital"
      }
    ]
  }
}
```

**updated** JSON:
```json
{
  "dateOfBirth": "1990-05-15",
  "title": "Developer",
  "manager":{
    "name": "Jaber",
    "title": "IT Manager"
  },
  "department": {
    "departmentName": "Development",
    "relatedDepartment": [
      {
        "departmentName": "Marketing"
      },
      {
        "departmentName": "Human Capital"
      },
      {
        "departmentName": "Business Development"
      }
    ]
  }
}
```

**diff** JSON should be:
```json
{
  "dateOfBirth": "1990-05-15",
  "manager":{
      "title": "IT Manager"
    },
    "department": {
      "relatedDepartment": [
        {
          "departmentName": "Marketing"
        },
        {
          "departmentName": "Human Capital"
        },
        {
          "departmentName": "Business Development"
        }
      ]
    }
}
```



Note: all these examples above are provided as test cases as part of the project