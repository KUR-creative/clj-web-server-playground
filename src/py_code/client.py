import requests
import edn_format as edn

'''
r = requests.get('http://localhost:3001')
print(r.text)
print(r.content)
#print(r.json())
print(edn_format.loads(r.text))


r = requests.post(
    'http://localhost:3001',
    data = edn_format.dumps(
        {1: [1,2,3,4,5], "asdf": 123}
    )
)
'''
import sys

dat = edn.dumps(
    {
    1: sys.argv[1],
    "asdf": 123,
    edn.Symbol("sym"): edn.Keyword(123)
    }
)
#print(dir(edn))

for _ in range(10):
    r = requests.post(
        'http://localhost:3001',
        data = sys.argv[1]
    )
